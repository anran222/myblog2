package lianxi;

import java.util.Scanner;

public class FrogJumps {
        public static int f(int n) {
            if(n!=1) {
                if(n!=2) {
                    return f(n-1)+f(n-2);
                }else return 2;
            }else return 1 ;
        }
        public static void main(String[] args) {
            System.out.println("请输入台阶数：");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            System.out.println("跳法总数："+"\n"+f(n));
        }
    }
