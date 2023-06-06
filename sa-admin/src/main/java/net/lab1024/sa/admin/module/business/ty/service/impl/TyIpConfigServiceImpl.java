package net.lab1024.sa.admin.module.business.ty.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyIpConfig;
import net.lab1024.sa.admin.module.business.ty.mapper.TyIpConfigMapper;
import net.lab1024.sa.admin.module.business.ty.service.ITyIpConfigService;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.httpclient.HttpClientUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * <p>
 * 虚拟IP 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Service
@Slf4j
public class TyIpConfigServiceImpl extends ServiceImpl<TyIpConfigMapper, TyIpConfig> implements ITyIpConfigService {

    String url = "http://api1.ydaili.cn/tools/BMeasureApi.ashx?action=BEAPI&secret=C34FC9CB982240F85FD3DD179B4AC402CE4E932A911A6EBC4B368F7B945A7ACB782476CC562FD394&number=1&orderId=SH20230603170718148&format=txt";
    @Override
    public void setIp() {
        try{
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id","1");
            TyIpConfig one = this.getOne(queryWrapper);
            String ip = HttpClientUtils.doGetOfReturnJson(url).trim();
            one.setIp(ip);
            this.updateById(one);
        }catch (Exception e) {
//            e.printStackTrace();
            log.info("【虚拟IP请求异常】---->", e.getMessage());
        }
    }

    @Override
    public String getIp() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id","1");
        TyIpConfig one = this.getOne(queryWrapper);
        return one.getIp();
    }

}
