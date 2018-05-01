package cn.slimsmart.springboot.taks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)//上一次开始执行时间点之后5秒再执行
    @Scheduled(fixedDelay = 5000) //上一次执行完毕时间点之后1秒再执
    @Scheduled(cron = "*/5 * * * * *") //通过cron表达式定义规则
    @Scheduled(initialDelay = 1000, fixedRate = 5000)//第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void task() {
        System.out.println("time:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

}
