package com.cn.hnust.utils;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时�?�中取出ApplicaitonContext.
 * 
 * @author zhuh
 */
public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	// 实现ApplicationContextAware接口的context注入函数, 将其存入静�?�变�?.
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	// 取得存储在静态变量中的ApplicationContext.
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	// 从静态变量ApplicationContext中取得Bean, 自动转型为所赋�?�对象的类型.
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	// 从静态变量ApplicationContext中取得Bean, 自动转型为所赋�?�对象的类型.
	// 如果有多个Bean符合Class, 取出第一�?.
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		@SuppressWarnings("rawtypes")
		Map beanMaps = applicationContext.getBeansOfType(clazz);
		if (beanMaps != null && !beanMaps.isEmpty()) {
			return (T) beanMaps.values().iterator().next();
		} else {
			return null;
		}
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注�?,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

}