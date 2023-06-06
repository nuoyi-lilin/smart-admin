package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ty_news_list")
@ApiModel(value="新闻列表", description="")
public class TyNewsList {

    @TableId(value = "id")
    private int id;

    private String img;

    private String title;

    private String newText;

    private int status;

    private Date creatTime;

    private Date updateTime;

    private int type;

    private int newsType;

    private int hot;

    private int hotType;

    private String newkey;

}
