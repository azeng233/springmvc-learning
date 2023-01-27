package cn.zengchen233.dao;

import cn.zengchen233.pojo.User;

import java.util.List;

/**
 * @author zengchen
 * @title UserDao
 * @description TODO
 * @create 2023/1/27 10:39
 */
public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);
}
