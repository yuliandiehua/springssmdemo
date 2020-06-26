package cn.kgc.ssm.service.test;

import cn.kgc.ssm.pojo.User;
import cn.kgc.ssm.service.UserService;
import cn.kgc.ssm.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    Logger logger=Logger.getLogger(UserServiceTest.class);
    private UserService userService;
    @Before
    public void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
         userService= context.getBean(UserService.class);
    }
    @Test
    public void getUserByUserCodeTest(){
        User user = this.userService.getUserByUserCode("admin");
        if(null==user){
            logger.info("用户不存在");
        }else{
            logger.info("查询结果："+user.toString());
        }

    }
    @Test
    public void login(){
        User user = this.userService.login("admin", "1234567");
        if(null==user){
            logger.info("登录失败");
        }

    }
}
