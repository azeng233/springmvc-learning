package cn.zengchen233.service;

import cn.zengchen233.exception.MyException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author zengchen
 * @title DemoServiceImpl
 * @description TODO
 * @create 2023/1/30 10:31
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public void show1() {
        System.out.println("抛出类型转换异常");
        Object str = "zengchen";
        Integer num = (Integer) str;
    }

    @Override
    public void show2() {
        System.out.println("抛出除零异常");
        int i = 1 / 0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("找不到文件异常");
        FileInputStream in = new FileInputStream("G:/xxx/xxx.txt");
    }

    @Override
    public void show4() {
        System.out.println("空指针异常...");
        String str = null;
        str.length();
    }

    @Override
    public void show5() throws MyException {
        System.out.println("自定义异常...");
        throw new MyException();
    }
}
