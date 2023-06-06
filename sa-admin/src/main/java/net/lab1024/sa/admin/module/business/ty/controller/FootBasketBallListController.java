package net.lab1024.sa.admin.module.business.ty.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.lab1024.sa.admin.constant.AdminSwaggerTagConst;
import net.lab1024.sa.admin.module.business.ty.service.ITyFootballScoreResultService;
import net.lab1024.sa.common.common.annoation.NoNeedLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ty_foot_basket_ball_list")
@Api(tags = AdminSwaggerTagConst.Business.TY_FOOT_BASKET_BALL_LIST)
public class FootBasketBallListController {

    @Autowired
    private ITyFootballScoreResultService footballScoreResultService;

    @ApiOperation("手动获取比分列表数据")
    @GetMapping("/footBasketBallList")
    @NoNeedLogin
    public void footBasketBallList() {
        footballScoreResultService.getFootballScoreResult();
    }

    @ApiOperation("手动获取足球重要列表数据")
    @GetMapping("/getFootballScoreImportant")
    @NoNeedLogin
    public void getFootballScoreImportant() {
        footballScoreResultService.getFootballScoreImportant();
    }
}
