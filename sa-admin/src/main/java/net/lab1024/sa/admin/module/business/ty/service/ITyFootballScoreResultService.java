package net.lab1024.sa.admin.module.business.ty.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyFootballScoreResult;
import net.lab1024.sa.admin.module.business.ty.domain.vo.FootballScoreResultVo;
import net.lab1024.sa.common.common.domain.ResponseDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
public interface ITyFootballScoreResultService extends IService<TyFootballScoreResult> {

    /** 晚上00：00：00调用一次 **/
    void getFootballScoreResult();
    /** 重要比赛 一分钟调一次 */
    void getFootballScoreImportant();

    /** 正在比赛  十秒调一次 */
    void getFootballScoreIng();

    ResponseDTO getFootBallList(FootballScoreResultVo footballScoreResultVo);
}
