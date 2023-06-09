package net.lab1024.sa.admin.module.business.job;

import net.lab1024.sa.admin.module.business.ty.service.ITyFootballScoreResultService;
import net.lab1024.sa.admin.module.business.ty.service.ITyIpConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 列表定时任务
 */
@Component
public class FootBasketBallListTask {

        @Autowired
        private ITyIpConfigService tyIpConfigService;

        @Autowired
        private ITyFootballScoreResultService tyFootballScoreResultService;

        // 每隔三分钟执行一次
        @Scheduled(cron = "0  */3  *  *  *  ?")
        public void setIp() {
            System.out.println("每隔3分支执行一次：" + new Date());
            tyIpConfigService.setIp();
        }

        /** 每隔一小时执行一次   */
        @Scheduled(cron = "0/5 * * * * ?")
        public void setImportUrl() {
            System.out.println("每隔一小时执行一次：" + new Date());
            tyIpConfigService.setImportUrl();
        }


        /** 每隔一小时执行一次   */
        @Scheduled(cron = "0/5 * * * * ?")
        public void getFootballScoreResult() {
            System.out.println("每隔一小时执行一次：" + new Date());
            tyFootballScoreResultService.getFootballScoreResult();
        }



        /** 每隔五秒执行一次   */
        @Scheduled(cron = "0/5 * * * * ?")
        public void getFootballScoreImportant() {
            System.out.println("每隔五秒执行一次：" + new Date());
            tyFootballScoreResultService.getFootballScoreImportant();
        }

        /** 每隔十秒执行一次   */
        @Scheduled(cron = "0/10 * * * * ?")
        public void getFootballScoreIng() {
            System.out.println("每隔十秒执行一次：" + new Date());
            tyFootballScoreResultService.getFootballScoreIng();
        }

}
