package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 纳米篮球阶段信息
 * </p>
 *
 * @author Bean
 * @since 2021-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_basketball_stages")
@ApiModel(value="纳米篮球赛事信息", description="")
public class NmBasketballStages extends Model<NmBasketballStages> {

    private static final long serialVersionUID=1L;

      /**
     * 阶段 id
     */
      @TableId
    private Long id;

      /**
     * 中文名称
     */
      private String nameZh;

      /**
     * 粤语名称
     */
      private String nameZht;

      /**
     * 英文名称
     */
      private String nameEn;


}
