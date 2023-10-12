package com.stonedt.intelligence.controller;

import com.stonedt.intelligence.entity.User;
import com.stonedt.intelligence.service.PlatformService;
import com.stonedt.intelligence.util.ResultUtil;
import com.stonedt.intelligence.util.UserUtil;
import com.stonedt.intelligence.vo.BindParamsVo;
import com.stonedt.intelligence.vo.CopyWriting;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;

/**
 * 跨平台服务控制层
 * @author 文轩
 */
@RestController
@RequestMapping(value = "/platform")
public class PlatformController {

    private final UserUtil userUtil;

    private final PlatformService platformService;

    public PlatformController(UserUtil userUtil,
                              PlatformService platformService) {
        this.userUtil = userUtil;
        this.platformService = platformService;
    }

    /**
     * nlp服务绑定
     */
    @PostMapping(value = "/nlp/bind")
    public ResultUtil nlpBind(@RequestBody BindParamsVo bindParamsVo, HttpServletRequest request) {
        // 获取用户id
        long userId = userUtil.getUserId(request);
        bindParamsVo.setUserId(userId);
        // 绑定
        return platformService.nlpBind(bindParamsVo);
    }

    /**
     * nlp光学字符识别
     */
    @PostMapping(value = "/nlp/ocr")
    public ResultUtil nlpOcr(MultipartFile images, HttpServletRequest request) {
        // 获取用户id
        User user = userUtil.getuser(request);
        if (!user.getNlp_flag().equals(1)){
            return ResultUtil.build(424, "未绑定nlp服务");
        }
        // 调用
        try {
            return platformService.nlpOcr(user, images);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.build(500, "ocr识别失败");
        }

    }

    /**
     * 写作宝绑定
     */
    @PostMapping(value = "/xie/bind")
    public ResultUtil xieBind(@RequestBody BindParamsVo bindParamsVo, HttpServletRequest request) {
        // 获取用户id
        long userId = userUtil.getUserId(request);
        bindParamsVo.setUserId(userId);
        // 绑定
        return platformService.xieBind(bindParamsVo);
    }

    /**
     * 写作宝绑定检查
     */
    @GetMapping(value = "/xie/checkBind")
    public ResultUtil xieCheckBind(HttpServletRequest request) {
        // 获取用户id
        User user = userUtil.getuser(request);
        // 绑定
        if (user.getXie_flag().equals(1)){
            return ResultUtil.ok();
        }else {
            return ResultUtil.build(424, "未绑定写作宝服务");
        }
    }

    /**
     * 写作宝智写报告
     */
    @PostMapping(value = "/xie/report")
    public SseEmitter xieReport(@RequestBody CopyWriting copyWriting, HttpServletRequest request) {
        // 获取用户
        User user = userUtil.getuser(request);

        // 调用
        return platformService.xieReport(user, copyWriting);
    }

}
