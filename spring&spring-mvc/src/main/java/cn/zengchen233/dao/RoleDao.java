package cn.zengchen233.dao;

import cn.zengchen233.pojo.Role;

import java.util.List;

/**
 * @author zengchen
 * @title RoleDao
 * @description TODO
 * @create 2023/2/1 8:57
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
