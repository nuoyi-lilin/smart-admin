package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * create table if not exists ty_news_information
 * (
 * id bigint auto_increment comment 'id'
 * primary key,
 * new_id bigint null comment '新闻id',
 * title varchar(255) null comment '新闻标题',
 * secode_title varchar(255) null comment '第二标题',
 * author varchar(255) null comment '新闻作者',
 * content text null comment '新闻内容',
 * status int(2) null comment '审核状态（0.审核失败  1.审核成功）',
 * match_type int(2) null comment '赛事分类（1.足球， 2.篮球）',
 * type int(2) null comment ' 赛事类型（1.世亚预 2.世欧预 3.欧冠杯 4.英超 5.NBA 6.CBA 7.意甲 8.西甲 9.德甲 10.法甲 11.中超 12.日职联 13.澳超 14.欧联杯 15.日职乙 16.韩K联）',
 * news_type int(2) null comment '资讯类型（1.最新资讯  2.热点资讯）',
 * num int(10) null comment '点赞次数',
 * views_num bigint null comment '浏览数（进库随机一个数字进行排序）',
 * gmt_create datetime null comment '创建时间',
 * gmt_modified datetime null comment '编辑时间',
 * cname varchar(255) null comment '标签类型',
 * image_url varchar(255) null comment '第一张显示的图片'
 * )
 * comment '新闻资讯';
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ty_news_information")
@ApiModel(value = "新闻资讯对象", description = "")
public class TyNewsInformation extends Model<TyNewsInformation> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "新闻id")
    private Integer newId;
    @ApiModelProperty(value = "新闻内容")
    private String content;
    @ApiModelProperty(value = "图片")
    private String img;
    @ApiModelProperty(value = "key")
    private String newkey;
    @ApiModelProperty(value = "赛事类型")
    private Integer type;
    @ApiModelProperty(value = "点赞数")
    private Integer num;
    @ApiModelProperty(value = "浏览数")
    private Integer viewsNum;
    @ApiModelProperty(value = "添加时间")
    private Date gmtCreate;
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}
