package net.lab1024.sa.admin.module.business.ty.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 状态码
 * 1	进球
 * 2	角球
 * 3	黄牌
 * 4	红牌
 * 5	界外球
 * 6	任意球
 * 7	球门球
 * 8	点球
 * 9	换人
 * 10	比赛开始
 * 11	中场
 * 12	结束
 * 13	半场比分
 * 15	两黄变红
 * 16	点球未进
 * 17	乌龙球
 * 19	伤停补时
 * 21	射正
 * 22	射偏
 * 23	进攻
 * 24	危险进攻
 * 25	控球率
 * 26	加时赛结束
 * 27	点球大战结束
 * 28	VAR(视频助理裁判)
 * 29	点球(点球大战)(type_v2字段返回)
 * 30	点球未进(点球大战)(type_v2字段返回)
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_football_match_detail")
@ApiModel(value="纳米-足球赛事详情信息", description="")
public class NmFootballMatchDetail {

    /**
     * 比赛ID
     */
    public Integer matchId;

    /**
     * 比赛状态
     * 0	比赛异常，说明：暂未判断具体原因的异常比赛，可能但不限于：腰斩、取消等等，建议隐藏处理
     * 1	未开赛
     * 2	上半场
     * 3	中场
     * 4	下半场
     * 5	加时赛
     * 6	加时赛(弃用)
     * 7	点球决战
     * 8	完场
     * 9	推迟
     * 10	中断
     * 11	腰斩
     * 12	取消
     * 13	待定
     */
    public Integer matchStatus;


    /**
     * 主队比分
     */
    public Integer homeScore;

    /**
     * 主队半场比分
     */
    public Integer homeHalfScore;

    /**
     * 主队红牌
     */
    public Integer homeRedCard;

    /**
     * 主队黄牌
     */
    public Integer homeYellowCard;

    /**
     * 主队角球
     */
    public Integer homeConner;

    /**
     * 主队加时比分
     */
    public Integer homeExtraScore;

    /**
     * 主队点球比分
     */
    public Integer homeSoloScore;

    /**
     * 控球率
     */
    public Integer homeCtrlBall;

    /**
     * 射正
     */
    public Integer homeShoot;

    /**
     * 射偏
     */
    public Integer homeShootMiss;

    /**
     * 进攻
     */
    public Integer homeAttack;

    /**
     * 危险进攻
     */
    public Integer homeAttackDanger;


    /**
     * 客队比分
     */
    public Integer awayScore;

    /**
     * 主队半场比分
     */
    public Integer awayHalfScore;

    /**
     * 主队红牌
     */
    public Integer awayRedCard;

    /**
     * 主队黄牌
     */
    public Integer awayYellowCard;

    /**
     * 主队角球
     */
    public Integer awayConner;

    /**
     * 主队加时比分
     */
    public Integer awayExtraScore;

    /**
     * 主队点球比分
     */
    public Integer awaySoloScore;

    /**
     * 控球率
     */
    public Integer awayCtrlBall;

    /**
     * 射正
     */
    public Integer awayShoot;

    /**
     * 射偏
     */
    public Integer awayShootMiss;

    /**
     * 进攻
     */
    public Integer awayAttack;

    /**
     * 危险进攻
     */
    public Integer awayAttackDanger;

    /**
     * 开球时间戳
     */
    public Integer openTimeStamp;
}
