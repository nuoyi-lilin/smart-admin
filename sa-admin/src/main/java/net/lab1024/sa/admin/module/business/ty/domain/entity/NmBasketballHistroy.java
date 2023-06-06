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
@TableName("nm_basketball_history")
@ApiModel(value="纳米-篮球历史数据", description="")
public class NmBasketballHistroy implements Serializable {
    private static final long serialVersionUID = 767077548831495880L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 比赛matchId
     */
    private Integer matchId;
    /**
     * 比赛id
     */
    private Integer gameId;
    /**
     * 赛事id
     */
    private Integer eventId;
    /**
     * 赛事名称
     */
    private String eventName;
    /**
     * 比赛时间
     */
    private String gameTime;
    /**
     * 主队球队id
     */
    private Integer homeId;
    /**
     * 主队名称
     */
    private String homeName;
    /**
     * 客队球队id
     */
    private Integer awayId;
    /**
     * 客队名称
     */
    private String awayName;
    /**
     * 主队总分
     */
    private int homeScore;
    /**
     * 客队总分
     */
    private int awayScore;
    /**
     * 走势
     */
    private BigDecimal trend;
    /**
     * 类型 1,历史交战 2.近期交战
     */
    private int type;
    /**
     * 进球
     */
    private BigDecimal goal;
    /**
     * 创建时间
     */
    private Date createTime;



}