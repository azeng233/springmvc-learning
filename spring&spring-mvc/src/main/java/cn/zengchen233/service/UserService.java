package cn.zengchen233.service;

import cn.zengchen233.pojo.User;

import java.util.List;

/**
 * @author zengchen
 * @title UserService
 * @description TODO
 * @create 2023/2/1 9:40
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleId);
}
