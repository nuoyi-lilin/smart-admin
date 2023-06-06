package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_football_team")
@ApiModel(value="纳米-足球队伍", description="")
public class NmFootballTeam {

    /**
     * 球队id
     */
    @TableId(value = "id")
    public Integer id;

    /**
     * 赛事id（球队所属联赛，杯赛不关联）
     */
    public Integer competitionId;

    /**
     * 国家id
     */
    public Integer countryId;

    /**
     * 中文名称
     */
    public String nameZh;

    /**
     * 中文简称
     */
    public String shortNameZh;

    /**
     * 粤语名称
     */
    public String nameZht;

    /**
     * 粤语简称
     */
    public String shortNameZht;

    /**
     * 英文名称
     */
    public String nameEn;

    /**
     * 英文简称
     */
    public String shortNameEn;

    /**
     * 球队logo
     */
    public String logo;

    /**
     * 是否国家队,1=是国家队,0=不是国家队
     */
    public Integer national;

    /**
     * 成立时间
     */
    public Integer foundationTime;

    /**
     * 球队官网
     */
    public String website;

    /**
     * 教练id
     */
    public Integer managerId;

    /**
     * 场馆id
     */
    public Integer venueId;

    /**
     * 市值
     */
    public Integer marketValue;

    /**
     * 市值单位
     */
    public String marketValueCurrency;

    /**
     * 总球员数，-1表示没有该字段数据
     */
    public Integer totalPlayers;

    /**
     * 非本土球员数，-1表示没有该字段数据
     */
    public Integer foreignPlayers;

    /**
     * 国家队球员数，-1表示没有该字段数据
     */
    public Integer nationalPlayers;

    /**
     * 更新时间
     */
    public Integer updatedAt;

}
