package cn.zengchen233.impl;

import cn.zengchen233.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author zengchen
 * @title UserDaoImpl
 * @description TODO
 * @create 2023/1/16 9:46
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save money...");
    }
}
