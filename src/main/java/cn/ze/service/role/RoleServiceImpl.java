package cn.ze.service.role;

import cn.ze.dao.BaseDao;
import cn.ze.dao.role.RoleDao;
import cn.ze.dao.role.RoleDaoImpl;
import cn.ze.entity.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    //引入Dao
    private RoleDao roleDao;

    public RoleServiceImpl(){
        this.roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList(){
        Connection connection = null;
        List<Role> list = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            list = roleDao.getRoleList(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return list;
    }

    @Test
    public void test(){
        RoleServiceImpl aaa = new RoleServiceImpl();
        List<Role> list = aaa.getRoleList();
        for(Role role : list){
            System.out.println(role.getRoleName());
        }

    }
}
