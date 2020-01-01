package lianxi;

import java.util.*;


public class Date2 {
    public static void main(String[] args) {
        Calendar calendar=new GregorianCalendar();//实例化对象
        System.out.println("YEAR:"+calendar.get(Calendar.YEAR));
        //获取年
        System.out.println("MONTH:"+calendar.get(calendar.MONTH)+1);
        //获取月
        System.out.println("DAY_OF_MONTH:"+calendar.get(Calendar.DAY_OF_MONTH));
        //获取日
        System.out.println("HOUR_OF_DAY:"+calendar.get(Calendar.HOUR_OF_DAY));
        //获取小时，24小时制
        System.out.println("MINUTE:"+calendar.get(Calendar.MINUTE));
        //获取分
        System.out.println("SECOND:"+calendar.get(Calendar.SECOND));
        //获取秒
        System.out.println("MILLISECOND:"+calendar.get(Calendar.MILLISECOND));
        //获取毫秒
    }
}
