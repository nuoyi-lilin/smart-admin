package net.lab1024.sa.admin.module.business.ty.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.lab1024.sa.admin.constant.AdminSwaggerTagConst;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyFootballScoreResult;
import net.lab1024.sa.admin.module.business.ty.domain.vo.FootballScoreResultVo;
import net.lab1024.sa.admin.module.business.ty.service.ITyFootballScoreResultService;
import net.lab1024.sa.common.common.annoation.NoNeedLogin;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
@RestController
@RequestMapping("/ty-football-score-result")
@Api(tags = AdminSwaggerTagConst.Business.TY_FOOT_BALL_LIST)
public class TyFootballScoreResultController {

    @Autowired
    private ITyFootballScoreResultService footballScoreResultService;

    @ApiOperation("获取足球比分列表数据")
    @PostMapping("/getFootBallList")
    @NoNeedLogin
    public ResponseDTO<TyFootballScoreResult> getFootBallList(@RequestBody FootballScoreResultVo footballScoreResultVo) {
       return footballScoreResultService.getFootBallList(footballScoreResultVo);
    }

}
