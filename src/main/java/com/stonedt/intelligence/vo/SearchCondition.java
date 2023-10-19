package com.stonedt.intelligence.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 文轩
 */
@Data
@Schema(name = "SearchCondition", description = "文章列表搜索条件")
public class SearchCondition {
    /**
     * 开始时间
     */
    @Schema(name = "times", description = "开始时间")
    private String times;
    /**
     * 结束时间
     */
    @Schema(name = "timee", description = "结束时间")
    private String timee;
    /**
     * 页码
     */
    @Schema(name = "page", description = "页码")
    private Integer page;
    /**
     * 排序方式
     * 1:倒序
     * 0:正序
     */
    @Schema(name = "searchType", description = "排序方式,1:倒序,0:正序")
    private Integer searchType;
    /**
     * 是否合并文章
     * 1:合并
     * 0:不合并
     */
    @Schema(name = "similar", description = "是否合并文章,1:合并,0:不合并")
    private Integer similar;
    /**
     * 匹配模式
     * 0:全文匹配
     * 1:标题匹配
     * 2:正文匹配
     */
    @Schema(name = "matchingmode", description = "匹配模式,0:全文匹配,1:标题匹配,2:正文匹配")
    private Integer matchingmode;
    /**
     * 情感属性
     * 1:正面
     * 2:中性
     * 3:负面
     */
    @Schema(name = "emotionalIndex", description = "情感属性,1:正面,2:中性,3:负面")
    private List<Integer> emotionalIndex;
    /**
     * 省份
     */
    @Schema(name = "province", description = "省份")
    private List<String> province;
    /**
     * 城市
     */
    @Schema(name = "city", description = "城市")
    private List<String> city;
//    /**
//     * 事件
//     */
//    private List<String> eventIndex;
//    /**
//     * 行业
//     */
//    private List<String> industryIndex;
    /**
     * 搜索关键词
     */
    @Schema(name = "searchkeyword", description = "搜索关键词")
    private String searchkeyword;
    /**
     * 方案id
     */
    @Schema(name = "projectid", description = "方案id")
    private String projectid;
    /**
     * 项目id
     */
    @Schema(name = "groupid", description = "方案组id")
    private String groupid;
    /**
     * 方案组id
     */
    @Schema(name = "group_id", description = "项目id")
    private String group_id;
    /**
     * 方案id
     */
    @Schema(name = "projectId", description = "方案组id")
    private String projectId;
    /**
     * 时间范围
     * 1:24小时内
     * 2:今日
     * 3:昨日
     * 4:近三天
     * 5:近一周
     * 6:近15天
     * 7:近一月
     * 8:自定义
     */
    @Schema(name = "timeType", description = "时间范围,1:24小时内,2:今日,3:昨日,4:近三天,5:近一周,6:近15天,7:近一月,8:自定义")
    private Integer timeType;
    /**
     * 是否打开精准筛选
     * 1:打开
     * 0:关闭
     */
    @Schema(name = "precise", description = "是否打开精准筛选,1:打开,0:关闭")
    private Integer precise;
    /**
     * 涉及机构
     */
    @Schema(name = "organizationtype", description = "涉及机构")
    private List<String> organizationtype;
    /**
     * 文章分类
     */
    @Schema(name = "categorylabledata", description = "文章分类")
    private List<String> categorylabledata;
    /**
     * 涉及企业类型
     */
    @Schema(name = "enterprisetypelist", description = "涉及企业类型")
    private List<String> enterprisetypelist;
    /**
     * 涉及高科技企业类型
     */
    @Schema(name = "hightechtypelist", description = "涉及高科技企业类型")
    private List<String> hightechtypelist;
    /**
     * 涉及政策
     */
    @Schema(name = "policylableflag", description = "涉及政策")
    private List<String> policylableflag;
    /**
     * 数据来源
     * 0:全部
     * 1:微信
     * 2:微博
     * 3:政务
     * 4:论坛
     * 5:新闻
     * 6:报刊
     * 7:客户端
     * 8:网站
     * 9:外媒
     * 10:视频
     * 11:博客
     */
    @Schema(name = "classify", description = "数据来源,0:全部,1:微信,2:微博,3:政务,4:论坛,5:新闻,6:报刊,7:客户端,8:网站,9:外媒,10:视频,11:博客")
    private List<String> classify;
    /**
     * 数据品类
     */
    @Schema(name = "datasource_type", description = "数据品类")
    private List<String> datasource_type;
    /**
     * 来源网站
     */
    @Schema(name = "sourceWebsite", description = "来源网站")
    private String sourceWebsite;
    /**
     * 作者
     */
    @Schema(name = "author", description = "作者")
    private String author;

}