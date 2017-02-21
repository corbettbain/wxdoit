package org.zsl.testmybatis;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.service.joke.impl.GetJoke;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.MessagesSend;
import com.cn.hnust.service.wx.msgsend.MessagesSendFactpry;
import com.cn.hnust.service.wx.msgsend.impl.MessagesSendFactpryImpl;
import com.cn.hnust.utils.SpringContextHolder;
import com.cn.hnust.utils.SpringContextUtil;

@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);
//  private ApplicationContext ac = null;
    @Resource
    private IUserService userService = null;

    
    @Inject
    private GetJoke getJoke;
    
//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        User user = userService.getUserById(1);
        // System.out.println(user.getUserName());
        // logger.info("ֵ��"+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }
    
    @Test
    public void test2(){
    	
    }
    
    @Test
    public void test3(){
    	JokeFactory jokeFactory = SpringContextHolder.getBean("getJoke");
    	WeatherService weatherService =  SpringContextUtil.getBean("weatherServiceImpl");
    	System.err.println(jokeFactory);
    	System.err.println(weatherService);
    }
}