package cn.ze.service.user;

import cn.ze.dao.BaseDao;
import cn.ze.dao.user.UserDao;
import cn.ze.dao.user.UserDaoImpl;
import cn.ze.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    //懒加载
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        connection = BaseDao.getConnection();
        user = userDao.getLoginUser(connection,userCode);
        return user;
    }

    @Override
    public boolean updatePwd(int id, String password) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePwd(connection,id,password) > 0){
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }


    //查询记录数
    @Override
    public int getUserCount(String name, int role) {
        Connection connection = null;
        int count = 0;

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection,name,role);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return count;
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName = " + queryUserName);
        System.out.println("queryUserRole = " + queryUserRole);
        System.out.println("currentPageNo = " + currentPageNo);
        System.out.println("pageSize = " + pageSize);

        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection,queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return userList;
    }

    //删除用户
    @Override
    public boolean deleteUserById(Integer delId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if(userDao.deleteUserById(connection,delId) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }


    @Override
    public User getUserById(String id) {
        User user = null;
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            user = userDao.getUserById(connection,id);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            user = null;
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }


    @Override
    public boolean modify(User user) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if(userDao.modify(connection,user) > 0)
                flag = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean add(User user) {
        // TODO Auto-generated method stub

        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userDao.add(connection,user);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null,2);
        System.out.println(userCount);
    }



}
