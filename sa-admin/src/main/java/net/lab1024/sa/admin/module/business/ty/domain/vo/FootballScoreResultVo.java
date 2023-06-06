package net.lab1024.sa.admin.module.business.ty.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.lab1024.sa.admin.module.business.goods.constant.GoodsStatusEnum;
import net.lab1024.sa.common.common.json.serializer.DictValueVoSerializer;
import net.lab1024.sa.common.common.swagger.ApiModelPropertyEnum;

@Data
public class FootballScoreResultVo {

    @ApiModelProperty("状态 (Played：赛果，Fixture：赛程， Playing 进行中 ，Uncertain 其他 )")
    private String status;

    @ApiModelProperty("时间")
    private String time;

    @ApiModelProperty("体育类型 soccer：足球 bkb：篮球")
    private String type;

}
