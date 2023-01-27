package cn.zengchen233.service;

import cn.zengchen233.pojo.User;

import java.util.List;

/**
 * @author zengchen
 * @title UserService
 * @description TODO
 * @create 2023/1/27 12:37
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
