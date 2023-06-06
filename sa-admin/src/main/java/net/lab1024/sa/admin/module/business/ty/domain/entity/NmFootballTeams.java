package net.lab1024.sa.admin.module.business.ty.domain.entity;

import cn.hutool.db.DaoTemplate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
@TableName("nm_football_teams")
@ApiModel(value="纳米篮球赛事信息", description="")
public class NmFootballTeams extends Model<NmFootballTeams> {

    private static final long serialVersionUID=1L;

      /**
     * 为球队 id
     */
      @TableId
        private int id;

      /**
     * 赛事id
     */
      private Long matcheventId;

      /**
     * 球队 logo，url 前缀
     */
      private String logo;

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

    /**
     *  创建时间
     */
     private Date createTime;

    /**
     * 编辑时间
     */
     private int updateTime;

}
