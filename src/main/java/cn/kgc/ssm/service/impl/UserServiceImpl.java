package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.dao.UserMapper;
import cn.kgc.ssm.pojo.User;
import cn.kgc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String userCode, String userPassword) {
        //根据用户编码将用户查询出来
        User user = this.userMapper.getUserByUserCode(userCode);
        //根据用户如果不为空，用户密码与传入密码进行比较
        //如果未真返回用户对象，如果为假返回空并将用回对象置为空（垃圾回收）
        if(null==user&&!userPassword.equals(user.getUserPassword())){
            user=null;
            return null;
        }

        return user;
    }

    @Override
    public boolean addUser(User user) {
        int i = this.userMapper.addUser(user);
        return i>0?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        int i = this.userMapper.updateUser(user);
        return i>0?true:false;
    }

    @Override
    public User gerUserById(int id) {
        User user = this.userMapper.getUserById(id);
        return user;
    }

    @Override
    public User getUserByUserCode(String userCode) {
        User user = this.userMapper.getUserByUserCode(userCode);
        return user;
    }

    @Override
    public List<User> findUserList(String userCode, String userName, Integer userRole, Integer currentPage, Integer pageSize) {
        //计算分页数据
        int begin=(currentPage-1)*pageSize;
        //调用持久层进行分页查询
        List<User> userList=new ArrayList<User>();
        userList = this.userMapper.findUserList(userCode, userName, userRole, currentPage, pageSize);

        return userList;
    }

    @Override
    public int getTotalCount(String userCode, String userName, Integer userRole) {
        return this.userMapper.getTotalCount(userCode, userName, userRole);
    }

}
