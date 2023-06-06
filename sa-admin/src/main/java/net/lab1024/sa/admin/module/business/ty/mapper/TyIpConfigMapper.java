package net.lab1024.sa.admin.module.business.ty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyIpConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 虚拟IP Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Mapper
@Component
public interface TyIpConfigMapper extends BaseMapper<TyIpConfig> {

}
