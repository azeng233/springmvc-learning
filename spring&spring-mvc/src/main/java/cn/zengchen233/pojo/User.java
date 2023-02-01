package cn.zengchen233.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author zengchen
 * @title User
 * @description TODO
 * @create 2023/1/27 10:40
 */
@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;

    //当前用户具备哪些角色
    private List<Role> roles;
}
