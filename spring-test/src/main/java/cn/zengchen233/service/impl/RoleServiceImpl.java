package cn.zengchen233.service.impl;

import cn.zengchen233.dao.RoleDao;
import cn.zengchen233.pojo.Role;
import cn.zengchen233.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zengchen
 * @title RoleServiceImpl
 * @description TODO
 * @create 2023/1/27 12:40
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
