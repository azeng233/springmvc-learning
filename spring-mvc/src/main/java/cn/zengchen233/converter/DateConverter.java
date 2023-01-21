package cn.zengchen233.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zengchen
 * @title DateConverter
 * @description TODO
 * @create 2023/1/21 9:49
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //日期字符串转换成日期对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
