package cn.zengchen233.dao.impl;

import cn.zengchen233.dao.UserDao;
import cn.zengchen233.pojo.User;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zengchen
 * @title UserDaoImpl
 * @description
 * @create 2023/2/1 9:41
 */
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> list() {
        List<User> list = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    /**
     * @description: TODO 完成查询用户id
     * @param user
     * @return: java.lang.Long
     */
    public Long save(User user) {
        jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)", null, user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNum());
        return 1L; // 返回当前保存用户的id
    }

    public void saveUserRoleRelation(Long userId, Long[] roleId) {
        for (Long aLong : roleId) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)", userId, roleId);
        }
    }
}
