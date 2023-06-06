package net.lab1024.sa.admin.module.business.ty.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_basketball_team_rank")
@ApiModel(value="纳米篮球球队排名信息", description="")
public class NmBasketballTeamRank {

    /**
     * 为球队 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 球队 logo，url 前缀
     */
    private String logo;

    /**
     * 球队id
     */
    private int teamId;

    /**
     * 球队名
     */
    private String teamName;

    /**
     * 积分榜表名称
     */
    private String name;

    /**
     * 所属阶段id
     */
    private int stageId;

    /**
     * 胜利场次
     */
    private int won;

    /**
     * 负的场次
     */
    private int loss;

    /**
     * 胜率
     */
    private String wonRate;

    /**
     * 排名
     */
    private int  position;

    /**
     * '东西部(1.东部.2西部)',
     */
    private int  type;

    /**
     * 联赛类型
     */
    private String  seaonType;

    private Date createTime;

    private int updateTime;

}
