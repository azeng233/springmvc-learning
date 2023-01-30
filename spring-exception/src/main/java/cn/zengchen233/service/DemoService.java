package cn.zengchen233.service;

import java.io.FileNotFoundException;

/**
 * @author zengchen
 * @title DemoService
 * @description TODO
 * @create 2023/1/30 10:30
 */
public interface DemoService {
    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;
}
