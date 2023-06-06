package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_football_match_player")
@ApiModel(value="纳米-足篮球视频源", description="")
public class NmFootballMatchPlayer {

    /**
     * 比赛ID
     */
    @TableId
    public Integer matchId;

    /**
     * 球员ID
     */
    public Integer playerId;

    /**
     * 球队ID
     */
    public Integer teamId;

    /**
     * 首发
     */
    public Integer first;

    /**
     * 进球
     */
    public Integer goals;

    /**
     * 点球
     */
    public Integer penalty;

    /**
     * 助攻
     */
    public Integer assists;

    /**
     * 出场时间(分钟)
     */
    public Integer minutesPlayed;

    /**
     * 红牌
     */
    public Integer redCards;

    /**
     * 黄牌
     */
    public Integer yellowCards;

    /**
     * 射门
     */
    public Integer shots;

    /**
     * 射正
     */
    public Integer shotsOnTarget;

    /**
     * 过人
     */
    public Integer dribble;

    /**
     * 过人成功
     */
    public Integer dribbleSucc;

    /**
     * 解围
     */
    public Integer clearances;

    /**
     * 有效阻挡
     */
    public Integer blockedShots;

    /**
     * 拦截
     */
    public Integer interceptions;

    /**
     * 抢断
     */
    public Integer tackles;

    /**
     * 传球
     */
    public Integer passes;

    /**
     * 传球成功
     */
    public Integer passesAccuracy;

    /**
     * 关键传球
     */
    public Integer keyPasses;

    /**
     * 传中球
     */
    public Integer crosses;

    /**
     * 传中球成功
     */
    public Integer crossesAccuracy;

    /**
     * 长传
     */
    public Integer longBalls;

    /**
     * 成功长传
     */
    public Integer longBallsAccuracy;

    /**
     * 1对1拼抢
     */
    public Integer duels;

    /**
     * 1对1拼抢成功
     */
    public Integer duelsWon;

    /**
     * 丢球
     */
    public Integer dispossessed;

    /**
     * 犯规
     */
    public Integer fouls;

    /**
     * 被侵犯
     */
    public Integer wasFouled;

    /**
     * 越位
     */
    public Integer offsides;

    /**
     * 两黄变红
     */
    public Integer yellow2redCards;

    /**
     * 补救
     */
    public Integer saves;

    /**
     * 拳击球
     */
    public Integer punches;

    /**
     * 守门员出击
     */
    public Integer runsOut;

    /**
     * 守门员出击成功
     */
    public Integer runsOutSucc;

    /**
     * 高空出击
     */
    public Integer goodHighClaim;

    /**
     *
     */
    public Integer rating;
}
