package com.stonedt.intelligence.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stonedt.intelligence.dao.UserDao;
import com.stonedt.intelligence.entity.User;
import com.stonedt.intelligence.service.PlatformService;
import com.stonedt.intelligence.util.ResultUtil;
import com.stonedt.intelligence.vo.BindParamsVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author 文轩
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    private final UserDao userDao;

    private final RestTemplate restTemplate;

    @Value("${platform.nlp.ocr-url}")
    private String nlpOcrUrl;

    public PlatformServiceImpl(UserDao userDao,
                               RestTemplate restTemplate) {
        this.userDao = userDao;
        this.restTemplate = restTemplate;
    }


    /**
     * nlp服务绑定
     *
     * @param bindParamsVo 绑定参数
     */
    @Override
    public ResultUtil nlpBind(BindParamsVo bindParamsVo) {

        try {
            userDao.bindNlp(bindParamsVo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.build(500, "绑定失败");
        }
        return ResultUtil.ok();
    }

    /**
     * nlp光学字符识别
     *
     * @param user   用户
     * @param images 图片
     */
    @Override
    public ResultUtil nlpOcr(User user, MultipartFile images) throws IOException {
        //调用nlp服务,参数为图片

        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();

        ByteArrayResource fileAsResource = new ByteArrayResource(images.getBytes()) {
            @Override
            public String getFilename() {
                return images.getOriginalFilename();
            }
            @Override
            public long contentLength() {
                return images.getSize();
            }
        };

        params.add("images", fileAsResource);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("secret-id",user.getNlp_secret_id());
        headers.set("secret-key",user.getNlp_secret_key());
        HttpEntity<MultiValueMap<String,Object>> requestEntity  = new HttpEntity<>(params, headers);
        String result = restTemplate.postForObject(nlpOcrUrl, requestEntity, String.class);

        if (result == null){
            return ResultUtil.build(500, "nlp服务调用失败");
        }
        JSONObject jsonObject = JSON.parseObject(result);
        return ResultUtil.ok(jsonObject);
    }
}
