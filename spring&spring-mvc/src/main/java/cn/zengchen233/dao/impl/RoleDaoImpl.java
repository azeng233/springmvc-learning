package cn.zengchen233.dao.impl;

import cn.zengchen233.dao.RoleDao;
import cn.zengchen233.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zengchen
 * @title RoleDaoImpl
 * @description
 * @create 2023/2/1 8:58
 */
@Component(value = "roleDao")
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        List<Role> list = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return list;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    public List<Role> findRoleByUserId(Long id) {
        List<Role> list = jdbcTemplate.query("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = ?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return list;
    }
}
