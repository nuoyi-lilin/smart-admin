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
 * 
 * </p>
 *
 * @author Bean
 * @since 2021-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("nm_basketball_matches")
@ApiModel(value="纳米篮球赛事信息", description="")
public class NmBasketballMatches extends Model<NmBasketballMatches> {

    private static final long serialVersionUID=1L;

      /**
     * 比赛 id
     */
      @TableId
        private Long id;

      /**
     * 比赛总节数
     */
      private Integer allSections;

      /**
     * 赛事 id
     */
      private Long eventId;

      /**
     * 比赛状态
     */
      private Integer gameStatus;

      /**
     * 比赛时间
     */
      private Long gameTime;

      /**
     * 当前小节所剩时间总秒数
     */
      private Integer surplus;

      /**
     * 主队 id
     */
      private Long homeTeamId;

      /**
     * 主队排名，无排名为空
     */
      private String homeRanking;

      /**
     * 主队第 1 节分数
     */
      private Integer homeSections1;

      /**
     * 主队第 2节分数
     */
      private Integer homeSections2;

      /**
     * 主队第 3节`数
     */
      private Integer homeSections3;

      /**
     * 主队第 4节分数
     */
      private Integer homeSections4;

      /**
     * 主队加时分数
     */
      private Integer homeOvertime;

      /**
     * 客队 id
     */
      private Long awayTeamId;

      /**
     * 客队排名，无排名为空
     */
      private String awayRanking;

      /**
     * 客队第 1 节分数
     */
      private Integer awaySections1;

      /**
     * 客队第 2 节分数
     */
      private Integer awaySections2;

      /**
     * 客队第 3 节分数
     */
      private Integer awaySections3;

      /**
     * 客队第 4 节分数
     */
      private Integer awaySections4;

      /**
     * 客队加时分数
     */
      private Integer awayOvertime;

      /**
     * 比赛详细说明
     */
      private String gameDetails;

      /**
     * 兼容，请忽略
     */
      private String compatible;

      /**
     * 是否有动画，未购买客户请忽略
     */
      private Integer hasAnimation;

      /**
     * 是否有情报，未购买客户请忽略
     */
      private Integer hasInformation;

      /**
     * 类型 1-常规赛 2-季后赛 3-季前赛 4-全明星 5-杯赛 0-无
     */
      private Integer gameType;

      /**
     * 阶段 id
     */
      private Long stageId;

      /**
     * 赛季 id
     */
      private Long seasonId;


}
