package cn.side4u;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonArg {
	/**
	 * Json 对象中的字段路径
	 * @return
	 */
	public String path();
}
