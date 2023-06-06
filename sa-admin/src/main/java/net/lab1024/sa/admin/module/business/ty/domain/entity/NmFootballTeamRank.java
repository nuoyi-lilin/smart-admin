package net.lab1024.sa.admin.module.business.ty.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_football_team_rank")
@ApiModel(value="足球球队榜", description="")
public class NmFootballTeamRank {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 数据id
     */
    private int dataId;

    /**
     * 球队id
     */
    private int  teamId;

    /**
     * 球队名
     */
    private String  teamName;

    /**
     * logo
     */
    private String  logo;

    /**
     *积分
     */
    private int points;

    /**
     * 排名
     */
    private int position;

    /**
     * 胜利场次
     */
    private int won;

    /**
     * 平的场次
     */
    private int draw;

    /**
     * 负的场次
     */
    private int loss;

    /**
     * 联赛类型
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
