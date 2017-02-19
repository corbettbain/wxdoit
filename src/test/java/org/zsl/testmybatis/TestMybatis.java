package org.zsl.testmybatis;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.joke.impl.GetJoke;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
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
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }
    
    @Test
    public void test2(){
    	
    }
    
    @Test
    public void test3(){
    	System.out.println(getJoke.get(1));
    }
}