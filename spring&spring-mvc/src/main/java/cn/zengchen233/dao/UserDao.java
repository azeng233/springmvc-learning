package cn.zengchen233.dao;

import cn.zengchen233.pojo.User;

import java.util.List;

/**
 * @author zengchen
 * @title UserDao
 * @description TODO
 * @create 2023/2/1 9:41
 */
public interface UserDao {
    List<User> list();

    Long save(User user);

    void saveUserRoleRelation(Long userId, Long[] roleIds);

    void delUserRoleRelation(Long id);

    void del(Long id);

    User login(String username, String password);
}
