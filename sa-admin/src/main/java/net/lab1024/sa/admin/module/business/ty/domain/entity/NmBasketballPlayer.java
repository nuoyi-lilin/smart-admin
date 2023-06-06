package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_basketball_player")
@ApiModel(value="纳米-篮球球员", description="")
public class NmBasketballPlayer {

    /**
     * 球队id
     */
    public Integer id;

    /**
     * 球队id,
     * 如果: 1.球员退役、2.自由球员、3.球队未知
     * team_id为0
     */
    public Integer teamId;

    /**
     * 生日
     */
    public Integer birthday;

    /**
     * 年龄
     */
    public Integer age;

    /**
     * 体重
     */
    public Integer weight;

    /**
     * 身高
     */
    public Integer height;

    /**
     * 国籍
     */
    public String nationality;

    /**
     * 市值
     */
    public Integer marketValue;


    /**
     * 合同截止时间
     */
    public String contractUntil;

    /**
     * 擅长位置
     * 位置，C-中锋、SF-小前锋、PF-大前锋、SG-得分后卫、PG-组织后卫、F-前锋、G-后卫，其它都为未知
     */
    public String position;

    /**
     * 中文名称
     */
    public String nameZh;

    /**
     * 粤语名称
     */
    public String nameZht;

    /**
     * 英文名称
     */
    public String nameEn;

    /**
     * 中文简称
     */
    public String shortNameZh;

    /**
     * 粤语简称
     */
    public String shortNameZht;

    /**
     * 英文简称
     */
    public String shortNameEn;

    /**
     * 球员logo
     */
    public String logo;

    /**
     * 国家队球员logo
     */
    public String nationalLogo;

    /**
     * 球衣编号
     */
    public Integer shirtNumber;

    /**
     * 更新时间
     */
    public Integer updatedAt;


}