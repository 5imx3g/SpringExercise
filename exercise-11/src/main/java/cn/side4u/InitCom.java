package cn.side4u;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
@Component
public class InitCom implements InitializingBean{

	/**
	 * 有时候需要初始化组件，但是构造函数中访问不到 Spring 注解的内容（生命周期早），因此需要此初始化方法
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("可以在此初始化组件。");
	}

}
