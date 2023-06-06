package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 历史交锋(NmBasketballHistroy)实体类
 *
 * @author pig4cloud
 * @since 2022-03-07 15:13:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_basketball_score_result")
@ApiModel(value="纳米-篮球历史数据", description="")
public class TyBasketballScoreResult implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 比赛matchId
     */
    private Integer matchId;

    /**
     * 赛事id
     */
    private Integer eventId;
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 主客队 （1.主队 2.客队）
     */
    private Integer homeAway;
    /**
     * 第一节
     */
    private Integer sectionOne;

    /**
     * 第二节
     */
    private Integer sectionTwo;

    /**
     * 第三节
     */
    private Integer sectionThree;

    /**
     * 第四节
     */
    private Integer sectionFour;

    /**
     * 加时
     */
    private Integer overTime;

    /**
     * 赛事名称
     */
    private String eventName="";
    /**
     * 比赛时间
     */
    private Integer gameTime;
    /**
     * 球队id
     */
    private Integer gameId;
    /**
     * 主队名称
     */
    private String homeName=null;
    /**
     * 上下半场总分
     */
    private String fullHalfScore;

    /**
     * 客队名称
     */
    private String awayName="";
    /**
     * 及时比分
     */
    private Integer scoreing;

    /**
     * 总分
     */
    private Integer Score;
    /**
     * 主队排名
     */
    private String homeRank;
    /**
     * 客队排名
     */
    private String awayRank;
    /**
     * 走势
     */
    private BigDecimal trend;

    /**
     * 分差
     */
    private Integer difference;




    /**
     * 是否有动画，1-是、0-否
     */
    private Integer mlive;
    /**
     * 更新时间
     */
    private Integer updateTime;
    /**
     * 创建时间
     */
    private Date createTime;



}