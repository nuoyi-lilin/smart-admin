package net.lab1024.sa.admin.module.business.ty.domain.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_football_player_rank")
@ApiModel(value="纳米-足球射手榜", description="")
public class NmFootballPlayerRank {

    /**
     * id
     */

    private int id;

    /**
     * 球员ID
     */
    private int  playerId;

    /**
     * 球队ID
     */
    private int  teamId;

    /**
     * 球员名称
     */
    private String  playerName;

    /**
     * 球员头像
     */
    private String  playerUrl;

    /**
     * 排名
     */
    private int playerRank;

    /**
      比赛场次
     */
    private int matchNum;


    /**
     * 进球数
     */
    private int goalNum;


    /**
     * 点球数
     */
    private int pointNum;


    /**
     * 联赛类型
     */
    private String type;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 编辑时间
     */
    private Date updateTime;

}
