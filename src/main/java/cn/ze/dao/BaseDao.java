package cn.ze.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

//操作数据库的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //类加载的时候就初始化
    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //获取数据库连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    //查询公共类
    public static ResultSet execute(Connection connection,PreparedStatement statement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        statement = connection.prepareStatement(sql);
        //这里没有写判断   params为空的情况
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i+1,params[i]);
        }

        resultSet = statement.executeQuery();
        return resultSet;
    }

    //插入(重载了)
    public static int execute(Connection connection,PreparedStatement statement,String sql,Object[] params) throws SQLException {
        statement = connection.prepareStatement(sql);
        //这里没有写判断   params为空的情况
       int row = 0;
        System.out.println("len = " + params.length);
        for (int i = 0; i < params.length; i++) {
            System.out.println("params" + i);
            statement.setObject(i+1,params[i]);
        }

        row = statement.executeUpdate();
        return row;
    }

    //释放资源
    public static boolean closeResource(Connection connection,PreparedStatement statement,ResultSet resultSet){
        boolean flag = true;

        if(resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if(statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }


        if(connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        return flag;

    }




}
