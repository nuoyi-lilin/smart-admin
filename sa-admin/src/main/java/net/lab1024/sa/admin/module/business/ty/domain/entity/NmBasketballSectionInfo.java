package net.lab1024.sa.admin.module.business.ty.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class NmBasketballSectionInfo implements Serializable {

    /**
     * 比赛id
     */
    private Integer matchId;

    /**
     * 比赛状态码
     */
    private int status;

    /**
     *  小节剩余时间(秒
     */
    private int time;

    /**
     * 1-主队、2-客队
     */
    private int team;

    /**
     * 第一节
     */
    private int sectionOne;

    /**
     * 第二节
     */
    private int sectionTwo;

    /**
     * 第三节
     */
    private int sectionThree;

    /**
     * 第四节
     */
    private int sectionFour;

    /**
     * 加时
     */
    private int overTime;

    /**
     * 总分
     */
    private int sectionTotal;
}
