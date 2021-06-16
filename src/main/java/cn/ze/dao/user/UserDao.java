package cn.ze.dao.user;

import cn.ze.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //增加用户信息
    public int add(Connection connection, User user)throws Exception;
    //得到登录的用户
    public User getLoginUser(Connection connection,String userCode);

    public int updatePwd(Connection connection, int id , String password) throws SQLException;

    //根據用戶名或者角色查詢用戶總數
    public int getUserCount(Connection connection,String name , int role) throws SQLException;

    //获取用户列表
    public List<User> getUserList(Connection connection,String name , int role , int currentPageNo,int pageSize)throws Exception;

    //删除用户
    public int deleteUserById(Connection connection, Integer delId)throws Exception;


    /**
     * 通过userId获取user
     * @param connection
     * @param id
     * @return
     * @throws Exception
     */
    public User getUserById(Connection connection, String id)throws Exception;

    /**
     * 修改用户信息
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    public int modify(Connection connection, User user)throws Exception;

}
