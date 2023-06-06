package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_sys_timer")
@ApiModel(value="纳米篮球赛事信息", description="")
public class NmSysTimer {


    public Integer nmTimerId;


    public String nmTimerName;


    public Integer nmTimerValue;
}
