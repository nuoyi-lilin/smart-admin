package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 历史交锋(NmBasketballHistroy)实体类
 *
 * @author pig4cloud
 * @since 2022-03-07 15:13:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ty_football_score_result")
@ApiModel(value="阿里球-足球比分数据", description="")
public class TyFootballScoreResult implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "比赛matchId")
    private Integer matchId;

    @ApiModelProperty(value = "联赛标题")
    private String matchTitle;

    @ApiModelProperty(value = "联赛ID")
    private Integer competitionId;

    @ApiModelProperty(value = "联赛名称")
    private String competitionName;

    @ApiModelProperty(value = "体育类型 soccer 足球")
    private String  type;

    @ApiModelProperty(value = "比赛时长")
    private String minute;

    @ApiModelProperty(value = "状态码")
    private String status;

    @ApiModelProperty(value = "半场比分")
    private String halfCourt;

    @ApiModelProperty(value = "比赛时间")
    private Long gameTime;

    @ApiModelProperty(value = "主队球队id")
    private Integer homeId;

    @ApiModelProperty(value = "主队名称")
    private String homeName;

    @ApiModelProperty(value = "主队logo")
    private String homeLogo;

    @ApiModelProperty(value = "客队球队id")
    private Integer awayId;

    @ApiModelProperty(value = "客队名称")
    private String awayName;

    @ApiModelProperty(value = "客队logo")
    private String awayLogo;

    @ApiModelProperty(value = "主队总分")
    private String homeScore;

    @ApiModelProperty(value = "客队总分")
    private String awayScore;

    @ApiModelProperty(value = "主队排名")
    private String homeRank;

    @ApiModelProperty(value = "客队排名")
    private String awayRank;

    @ApiModelProperty(value = "日期")
    private String time;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;



}