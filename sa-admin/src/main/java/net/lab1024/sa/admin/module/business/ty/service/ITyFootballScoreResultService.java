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

    void getFootballScoreResult();

    void getFootballScoreImportant();


    ResponseDTO getFootBallList(FootballScoreResultVo footballScoreResultVo);
}
