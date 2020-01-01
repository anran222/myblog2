package lianxi;

import java.text.*;
import java.util.*;

public class Date1 {
    public static void main(String[] args) {
        String strDate="2008-10-19 10:11:30.345";
        //准备第一个模板，从字符串中提取出日期数字
        String part1="yyyy-MM--dd HH:mm:ss.SSS";
        //准备第二个模板，将提取后的日期变为指定格式
        String part2="yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
        //实例化模板对象
        SimpleDateFormat sdf1=new SimpleDateFormat(part1);
        //实例化模板对象
        SimpleDateFormat sdf2=new SimpleDateFormat(part2);
        Date d=null;
        try {
            d=sdf1.parse(strDate);   //将给定的字符串中的日期提取出来
        }catch(Exception e){          //如果提供的字符串格式有误，则进行异常处理
            e.printStackTrace();        //打印异常信息
        }
        System.out.println(sdf2.format(d)); // 将日期变为新的格式
        }
    }
