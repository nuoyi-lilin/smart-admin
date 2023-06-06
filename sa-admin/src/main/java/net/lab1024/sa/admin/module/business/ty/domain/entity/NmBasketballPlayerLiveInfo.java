package net.lab1024.sa.admin.module.business.ty.domain.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class NmBasketballPlayerLiveInfo implements Serializable {
    /**
     * 比赛id
     */
    public Integer matchId;

    /**
     * 球员id
     */
    public Integer playerId;

    /**
     * 是否主队
     */
    public Integer isHome;

    /**
     * 中文名称
     */
    public String nameZh;

    /**
     * 英文名称
     */
    public String nameEn;

    /**
     * 粤语名称
     */
    public String nameZht;

    /**
     * logo
     */
    public String logo;

    /**
     * 球衣号码
     */
    public Integer shirtNumber;

    /**
     *  在场持续时间^
     */
    public Integer StayDuration;

    /**
     * 命中次数
     */
    public Integer HitCount;

    /**
     * 投篮次数
     */
    public Integer pushCount;

    /**
     * 三分球命中次数
     */
    public Integer hitCountThree;

    /**
     * 三分球投篮次数
     */
    public Integer pushCountThree;

    /**
     * 罚球命中次数
     */
    public Integer hitCountPenalty;

    /**
     * 罚球投篮次数
     */
    public Integer pushCountPenalty;

    /**
     * 进攻篮板
     */
    public Integer offensiveRebound;

    /**
     * 防守篮板
     */
    public Integer defensiveRebound;

    /**
     * 总的篮板
     */
    public Integer totalRebound;

    /**
     * 助攻数
     */
    public Integer assist;

    /**
     * 抢断数
     */
    public Integer steals;

    /**
     * 盖帽数
     */
    public Integer blocks;

    /**
     * 失误数
     */
    public Integer faults;

    /**
     * 个人犯规次数
     */
    public Integer fouls;

    /**
     * 得分
     */
    public Integer score;

    /**
     * 是否出场
     */
    public Integer inGround;

    /**
     * 是否替补
     * 是否是替补（1-替补，0-首发）
     */
    public Integer isSubstitution;
}
