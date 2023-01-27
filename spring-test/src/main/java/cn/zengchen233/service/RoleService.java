package cn.zengchen233.service;

import cn.zengchen233.pojo.Role;

import java.util.List;

/**
 * @author zengchen
 * @title RoleService
 * @description TODO
 * @create 2023/1/27 12:37
 */
public interface RoleService {
    public List<Role> list() ;

    void save(Role role);
}
