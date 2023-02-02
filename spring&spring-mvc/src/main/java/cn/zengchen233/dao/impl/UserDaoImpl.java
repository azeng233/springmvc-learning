package cn.zengchen233.dao.impl;

import cn.zengchen233.dao.UserDao;
import cn.zengchen233.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                //使用原始jdbc完成PreparedStatement组建
                PreparedStatement statement = conn.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setObject(1, null);
                statement.setString(2, user.getUsername());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getPhoneNum());
                return statement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, holder);

        //获得生成的主键
        return holder.getKey().longValue(); // 返回当前保存用户的id
    }

    public void saveUserRoleRelation(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)", userId, roleId);
        }
    }

    public void delUserRoleRelation(Long id) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", id);
    }

    public void del(Long id) {
        jdbcTemplate.update("delete from sys_user where id=?", id);
    }

    public User login(String username, String password) {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
