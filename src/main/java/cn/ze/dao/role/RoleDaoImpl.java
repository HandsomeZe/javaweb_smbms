package cn.ze.dao.role;

import cn.ze.dao.BaseDao;
import cn.ze.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{

    //获取角色列表
    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Role> list = new ArrayList<>();
        if(connection != null){
            String sql = "select *from smbms_role";
            Object[] params = {};
            rs = BaseDao.execute(connection,statement,rs,sql,params);
            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("roleName"));
                role.setRoleCode(rs.getString("roleCode"));
                list.add(role);
            }
            BaseDao.closeResource(null,statement,rs);
        }
        return list;
    }
}
