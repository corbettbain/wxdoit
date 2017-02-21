package com.cn.hnust.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����10:26:57
* ��˵��
*/
public class SpringContextUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext;     //SpringӦ�������Ļ���  
	   
	  /** 
	  * ʵ��ApplicationContextAware�ӿڵĻص����������������Ļ���    
	  * @param applicationContext 
	  * @throws BeansException 
	  */  
	  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {  
	    SpringContextUtil.applicationContext = applicationContext;  
	  }  
	   
	  /** 
	  * @return ApplicationContext 
	  */  
	  public static ApplicationContext getApplicationContext() {  
		  checkApplicationContext();
	    return applicationContext;  
	  }  
	   
	  /** 
	  * ��ȡ����    
	 * @param <T>
	  * @param name 
	  * @return Object һ������������ע���bean��ʵ�� 
	  * @throws BeansException 
	  */  
	  @SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {  
		  checkApplicationContext();
	    return (T) applicationContext.getBean(name);  
	  }  
	   
	  /** 
	  * ��ȡ����ΪrequiredType�Ķ��� 
	  * ���bean���ܱ�����ת������Ӧ���쳣���ᱻ�׳���BeanNotOfRequiredTypeException�� 
	  * @param name       beanע���� 
	  * @param requiredType ���ض������� 
	  * @return Object ����requiredType���Ͷ��� 
	  * @throws BeansException 
	  */  
	  @SuppressWarnings("unchecked")
	public static Object getBean(String name, @SuppressWarnings("rawtypes") Class requiredType) throws BeansException {  
		  checkApplicationContext();
	    return applicationContext.getBean(name, requiredType);  
	  }  
	   
	  /** 
	  * ���BeanFactory����һ������������ƥ���bean���壬�򷵻�true  
	  * @param name 
	  * @return boolean 
	  */  
	  public static boolean containsBean(String name) {  
		  checkApplicationContext();
	    return applicationContext.containsBean(name);  
	  }  
	   
	  /** 
	  * �ж��Ը�������ע���bean������һ��singleton����һ��prototype�� 
	  * ��������������Ӧ��bean����û�б��ҵ��������׳�һ���쳣��NoSuchBeanDefinitionException��    
	  * @param name 
	  * @return boolean 
	  * @throws NoSuchBeanDefinitionException 
	  */  
	  public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {  
		  checkApplicationContext();
	    return applicationContext.isSingleton(name);  
	  }  
	   
	  /** 
	  * @param name 
	  * @return Class ע���������� 
	  * @throws NoSuchBeanDefinitionException 
	  */  
	  @SuppressWarnings("rawtypes")
	public static Class getType(String name) throws NoSuchBeanDefinitionException {  
		  checkApplicationContext();
	    return applicationContext.getType(name);  
	  }  
	   
	  /** 
	  * ���������bean������bean�������б������򷵻���Щ����    
	  * @param name 
	  * @return 
	  * @throws NoSuchBeanDefinitionException 
	  */  
	  public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {  
		  checkApplicationContext();
	    return applicationContext.getAliases(name);  
	  }  
	  
	  private static void checkApplicationContext() {
			if (applicationContext == null) {
				throw new IllegalStateException("applicaitonContextδע��,����applicationContext.xml�ж���SpringContextHolder");
			}
		}
}
