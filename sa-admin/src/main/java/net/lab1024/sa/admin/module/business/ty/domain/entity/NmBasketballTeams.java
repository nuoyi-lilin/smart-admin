package net.lab1024.sa.admin.module.business.ty.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 纳米篮球球队信息
 * </p>
 *
 * @author Bean
 * @since 2021-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_basketball_teams")
@ApiModel(value="纳米篮球赛事信息", description="")
public class NmBasketballTeams extends Model<NmBasketballTeams> {

    private static final long serialVersionUID=1L;

      /**
     * 为球队 id
     */
    private Integer id;

      /**
     * 球队 logo，url 前缀
     */
      private String logo="";

      /**
     * 中文名称
     */
      private String nameZh="";

      /**
     * 粤语名称
     */
      private String nameZht;

      /**
     * 英文名称
     */
      private String nameEn;

      /**
     * 中文简称
     */
      private String shortNameZh;

      /**
     * 粤语简称
     */
      private String shortNameZht;

      /**
     * 英文简称
     */
      private String shortNameEn;

      /**
       * 赛事id  (关联nm_basketball_events id)
       */
      private int  competitionId;

      /**
       * 赛区id，1-大西洋赛区、2-中部赛区、3-东南赛区、4-太平洋赛区、5-西北赛区、6-西南赛区、7-A组赛区、8-B组赛区、9-C组赛区、10-D组赛区（1~6:NBA 7~10:CBA）、0-无
       */
      private int  conferenceId;

      private int updatedAt;

}
