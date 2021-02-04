package cn.side4u;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
•AspectJ 支持 5 种类型的通知注解:

–@Before: 前置通知, 在方法执行之前执行

–@After: 后置通知, 在方法执行之后执行

–@AfterRunning: 返回通知, 在方法返回结果之后执行

–@AfterThrowing: 异常通知, 在方法抛出异常之后

–@Around: 环绕通知, 围绕着方法执行
*/

@Aspect
@Component
public class LoggerAdvice {
public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 当在包 cn.side4u 下面，并且有 methodLooger 注解时，方法开始执行前触发
	 * @param joinPoint
	 * @param userLogger
	 */
	@Before("within(cn.side4u..*) && @annotation(methodLogger)")
	public void addBeforeLogger(JoinPoint joinPoint, MethodLogger methodLogger) {
		// 记录描述信息到日志
		log(methodLogger, "执行 " + methodLogger.msg() + " 开始");
		// 记录方法名到日志
		log(methodLogger, joinPoint.getSignature().toString());
		// 记录方法参数到日志
		log(methodLogger, parseParames(joinPoint.getArgs()));
	}
	
	/**
	 * 当在包 cn.side4u 下面，并且有 methodLooger 注解时，方法返回后触发
	 * @param joinPoint
	 * @param userLogger
	 */
	@AfterReturning("within(cn.side4u..*) && @annotation(methodLogger)")
	public void addAfterReturningLogger(JoinPoint joinPoint, MethodLogger methodLogger) {
		// 记录日志
		log(methodLogger, "执行 " + methodLogger.msg() + " 结束");
	}
	
	/**
	 * 当在包 cn.side4u 下面，并且有 methodLooger 注解时，方法抛出异常后触发
	 * @param joinPoint
	 * @param userLogger
	 * @param ex
	 */
	@AfterThrowing(pointcut = "within(cn.side4u..*) && @annotation(methodLogger)", throwing = "ex")
	public void addAfterThrowingLogger(JoinPoint joinPoint, MethodLogger methodLogger, Exception ex) {
		// 记录日志
		logger.error("执行 " + methodLogger.msg() + " 异常", ex);
	}
	
	/**
	 * 将参数信息解析成可读的字符串
	 * @param parames
	 * @return
	 */
	private String parseParames(Object[] parames) {
		if (null == parames || parames.length <= 0) {
			return "";
		}
		StringBuffer param = new StringBuffer("传入参数[{}] ");
		for (Object obj : parames) {
			param.append(ToStringBuilder.reflectionToString(obj)).append("  ");
		}
		return param.toString();
	}
	
	/**
	 * 包装一个日志方法
	 * @param userLogger
	 * @param msg
	 */
	private void log(MethodLogger userLogger, String msg) {
		if (userLogger.level().equalsIgnoreCase("INFO")) {
			logger.info(msg);
		} else if (userLogger.level().equalsIgnoreCase("Debug")) {
			logger.debug(msg);
		}
	}
}
