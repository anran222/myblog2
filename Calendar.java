package jiaqi3;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @Author:xiang
 * @Date:2020/2/4 21:34
 * 日历
 */
public class Calendar {
    public static void main(String[] args) {
        System.out.println("请输入日期（格式为2010-10-02）：");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println("你刚刚输入的时间是："+str);
        String[] str2=str.split("-");
        int year=Integer.parseInt(str2[0]);
        int month=new Integer(str2[1]);
        int day=new Integer(str2[2]);
        GregorianCalendar c=new GregorianCalendar(year,month-1,day);
        c.set(GregorianCalendar.DATE,1);
        int dow=c.get(GregorianCalendar.DAY_OF_WEEK);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i = 0; i <dow-1 ; i++) {
            System.out.print("\t");
        }
        int MaxDate=c.getActualMaximum(GregorianCalendar.DATE);
        for (int i = 1; i <=MaxDate ; i++) {
            StringBuilder sb=new StringBuilder();
            if (c.get(GregorianCalendar.DATE)==day){
                sb.append(c.get(GregorianCalendar.DATE)+"*\t");
            }else{
                sb.append(c.get(GregorianCalendar.DATE)+"\t");
            }
            System.out.print(sb);
            if (c.get(GregorianCalendar.DAY_OF_WEEK)==GregorianCalendar.SATURDAY){
                System.out.println("\n");
            }
            c.add(GregorianCalendar.DATE,1);
        }
    }
}
