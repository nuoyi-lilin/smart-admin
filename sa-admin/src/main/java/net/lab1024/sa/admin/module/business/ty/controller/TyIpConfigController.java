package net.lab1024.sa.admin.module.business.ty.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.lab1024.sa.admin.constant.AdminSwaggerTagConst;
import net.lab1024.sa.admin.module.business.category.domain.form.CategoryAddForm;
import net.lab1024.sa.admin.module.business.ty.service.ITyIpConfigService;
import net.lab1024.sa.admin.module.business.ty.service.impl.TyIpConfigServiceImpl;
import net.lab1024.sa.common.common.annoation.NoNeedLogin;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 虚拟IP 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@RestController
@RequestMapping("/ty-ip-config")
@Api(tags = AdminSwaggerTagConst.Business.TY_IP)
public class TyIpConfigController {

    @Autowired
    private ITyIpConfigService tyIpConfigService;

    @ApiOperation("修改IP")
    @GetMapping("/ty/setIp")
    @NoNeedLogin
    public void setIp() {
         tyIpConfigService.setIp();
    }
}
