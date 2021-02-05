package cn.side4u;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class SchTask {
	
	@Autowired
	TaskScheduler taskScheduler;
	
	private Long tic = 0l;
	
	/**
	 * fixed rate 是两个方法开始时间间隔来计算的
	 */
	@Scheduled(fixedRate = 1000)
	public void ticket() {
		System.out.println("current ticket is " + (tic++));
	}
	
	/*
	 * fixed delay 是方法结束到开始的时间
	 */
	@Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
	public void fiexdDelay() {
		System.out.println("fixed delay = 1000" + tic);
		startByCode();
	}
	
	/**
	 * 使用 cron 表达式
	 */
	@Scheduled(cron = "*/3 * * * * *")
	public void cronExpress() {
		System.out.println("cron 表达式，定时更灵活");
	}
	
	public void startByCode() {
		ScheduledFuture sf = taskScheduler.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("我是代码启动的，不是注解启动的");
				
			}
		}, new CronTrigger("0 */1 * * * *"));
	}

}
