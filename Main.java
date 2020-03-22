package test1;

import java.util.Scanner;

/**
 * @Author:xiang
 * @Date:2020/3/22 12:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] arr1=str.toCharArray();
        char[] arr2=new char[100];
        int m=0;
        arr2[m]=arr1[0];
        m++;
        for (int i = 0; i <arr1.length ; i++) {
            if (panduan(arr1[i],arr2)==false){
                arr2[m]=arr1[i];
                m++;
            }
        }
        for (int i = 0; i <m ; i++) {
            System.out.print(arr2[i]);
        }
    }

    public static boolean panduan(char s,char[] arr){
        for (int i = 0; i <arr.length ; i++) {
            if (s==arr[i]){
                return true;
            }
        }
        return false;
    }
}
