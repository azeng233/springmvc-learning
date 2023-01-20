package cn.zengchen233.pojo;

import java.util.List;

/**
 * @author zengchen
 * @title VO
 * @description TODO
 * @create 2023/1/20 9:40
 */
public class VO {
    private List<User> list;

    public VO() {
    }

    public VO(List<User> list) {
        this.list = list;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "VO{" +
                "list=" + list +
                '}';
    }
}
