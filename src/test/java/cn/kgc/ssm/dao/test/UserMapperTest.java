package cn.kgc.ssm.dao.test;


import cn.kgc.ssm.dao.UserMapper;
import cn.kgc.ssm.pojo.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class UserMapperTest {

    Logger logger=Logger.getLogger(UserMapperTest.class);
    //private UserMapper userMapper;
    private  ApplicationContext context;
    @Before
    public void init(){
        context=new ClassPathXmlApplicationContext("spring-config.xml");
        //userMapper=context.getBean(UserMapper.class);
    }

    /**
     * id查询用户
     */
    @Test
    public void getUserById(){
        User user =context.getBean(UserMapper.class).getUserById(1);
        logger.info(user);
    }

    /**
     * 增加用户
     */
    @Test
    public void addUser(){
        User user=new User();
        user.setAddress("洛阳");
        user.setBirthday(new Date());
        user.setCreatedBy(1);
        user.setCreationDate(new Date());
        user.setGender(1);
        user.setPhone("15648365493");
        user.setUserCode("111111");
        user.setUserName("小明");
        user.setUserRole(2);
        int i=context.getBean(UserMapper.class).addUser(user);
        logger.info("查询结果:"+(i>0?"成功":"失败"));
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        int i = context.getBean(UserMapper.class).deleteUser(16);
        logger.info("删除结果:"+(i>0?"成功":"失败"));
    }
    @Test
    public void updateUser(){
        User user = context.getBean(UserMapper.class).getUserById(16);
        user.setUserCode("2222");
        user.setModifyDate(new Date());
        user.setModifyBy(1);
        int i = context.getBean(UserMapper.class).updateUser(user);
        logger.info("更新结果:"+(i>0?"成功":"失败"));
    }
    @Test
    public void updateUserPassword(){
        int i = context.getBean(UserMapper.class).updateUserPassword(16, "11111111");
        logger.info("密码修改结果:"+(i>0?"成功":"失败"));
    }

    @Test
    public void findUserList(){
        List<User> list = context.getBean(UserMapper.class).findUserList(null, null, null, 1, 4);
        for(User user:list){
            logger.info("用户姓名："+user.getUserName());
        }
    }
    @Test
    public void getTotalCount(){
        int count = context.getBean(UserMapper.class).getTotalCount("ad", null, 1);
        logger.info("查询结果："+count);
    }
}
