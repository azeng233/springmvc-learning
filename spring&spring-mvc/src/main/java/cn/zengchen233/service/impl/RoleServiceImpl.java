package cn.zengchen233.service.impl;

import cn.zengchen233.dao.RoleDao;
import cn.zengchen233.pojo.Role;
import cn.zengchen233.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zengchen
 * @title RoleServiceImpl
 * @description TODO
 * @create 2023/2/1 8:54
 */
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
