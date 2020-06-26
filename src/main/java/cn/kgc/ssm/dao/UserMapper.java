package cn.kgc.ssm.dao;

import cn.kgc.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface UserMapper {
    /**
     * 根据用户编码查询用户信息
     * @param userCode
     * @return
     */
    User getUserByUserCode(@Param("userCode")String userCode);

    /**
     * 根据用户id查询用户信息
    * @param id
     * @return
     */
    User getUserById(@Param("id")Integer id);
    /**
     * 增加用户
     */
    int addUser(User user);
    /**
     * 更新用户信息
     */
    int updateUser(User user);
    /**
     * 用户密码修改
     */
    int updateUserPassword(@Param("id") int id,@Param("password") String password);
    /**
     * 删除用户
     */
    int deleteUser(@Param("id") int id);
    /**
     * 分页查询用户集合
     */
    List<User> findUserList(@Param("userCode")String userCode,@Param("userName")String userName,@Param("userRole")Integer userRole,@Param("begin")Integer begin,@Param("pageSize")Integer pageSize);
    /**
     * 查询用户总数量
     */
    int getTotalCount(@Param("userCode")String userCode,@Param("userName")String userName,@Param("userRole")Integer userRole);
}
