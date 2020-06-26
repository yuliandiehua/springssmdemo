package cn.kgc.ssm.service;

import cn.kgc.ssm.pojo.User;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface UserService {
    /**
     * 登录
     * @param userCode
     * @param userPassword
     * @return
     */
    User login(String userCode,String userPassword);

    /**
     * 增加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User gerUserById(int id);

    /**
     * 根据用户编号查询用户
     * @param userCode
     * @return
     */
    User getUserByUserCode(String userCode);

    /**
     * 分页查询用户列表
     * @param userCode
     * @param userName
     * @param userRole
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<User> findUserList(String userCode,String userName,Integer userRole,Integer currentPage,Integer pageSize);

    /**
     * 按条件查询用户数量
     * @param userCode
     * @param userName
     * @param userRole
     * @return
     */
    int getTotalCount(String userCode,String userName,Integer userRole);
}
