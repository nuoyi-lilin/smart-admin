package net.lab1024.sa.admin.module.business.ty.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyIpConfig;
import net.lab1024.sa.common.common.domain.ResponseDTO;

/**
 * <p>
 * 虚拟IP 服务类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
public interface ITyIpConfigService extends IService<TyIpConfig> {

    public void setIp();

    public String  getIp() ;

    /** 一个小时调一次 */
    public void setImportUrl();

}
