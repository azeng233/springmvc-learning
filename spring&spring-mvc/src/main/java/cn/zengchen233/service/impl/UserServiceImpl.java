package cn.zengchen233.service.impl;

import cn.zengchen233.dao.RoleDao;
import cn.zengchen233.dao.UserDao;
import cn.zengchen233.pojo.Role;
import cn.zengchen233.pojo.User;
import cn.zengchen233.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zengchen
 * @title UserServiceImpl
 * @description TODO
 * @create 2023/2/1 9:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public List<User> list() {
        List<User> userList = userDao.list();
        //封装userList中的每一个roles数据
        for (User user : userList) {
            //获得userid
            Long id = user.getId();
            //将id作为参数 查询当前userId的Role数据集合
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleId) {
        //第一步 向sys_user存储数据
        Long userId = userDao.save(user);

        //第二步 向sys_user_role存储多余数据
        userDao.saveUserRoleRelation(userId, roleId);
    }
}
