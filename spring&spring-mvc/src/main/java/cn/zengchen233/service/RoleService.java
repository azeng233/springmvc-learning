package cn.zengchen233.service;

import cn.zengchen233.pojo.Role;

import java.util.List;

/**
 * @author zengchen
 * @title RoleService
 * @description TODO
 * @create 2023/2/1 8:53
 */
public interface RoleService {
    List<Role> list();

    void save(Role role);
}
