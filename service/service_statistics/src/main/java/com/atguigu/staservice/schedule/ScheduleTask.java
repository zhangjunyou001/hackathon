package com.atguigu.staservice.schedule;

import com.atguigu.staservice.service.StatisticsDailyService;
import com.atguigu.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTask {

    @Autowired
    private StatisticsDailyService dailyService;

    @Autowired
    private StatisticsDailyService staService;

//    /**
//     * // 0/5 * * * * ?表示每隔5秒执行一次这个方法
//     */
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void task1() {
//        System.out.println("**************task1执行了..");
//    }

    /**
     * 在每天凌晨1点，把前一天数据进行数据查询添加
     * 在整和 SpringBoot项目时，七域表达式只能填写六位，第七位（年）默认为当前年
     * 只能写六位，写七位会报错
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        staService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }
}
