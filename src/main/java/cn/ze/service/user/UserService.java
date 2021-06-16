package cn.ze.service.user;

import cn.ze.entity.User;

import java.util.List;

public interface UserService {
    public User login(String userCode,String password);

    //根据用户ID修改密码
    public boolean updatePwd(int id , String password);

    //查询记录数
    public int getUserCount(String name ,int role);

    //获取用户列表
    public List<User> getUserList(String queryUserName,int queryUserRole , int currentPageNo, int pageSize);

    //删除用户
    public boolean deleteUserById(Integer delId);

    /**
     * 根据ID查找user
     * @param id
     * @return
     */
    public User getUserById(String id);


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean modify(User user);

    public boolean add(User user);

}
