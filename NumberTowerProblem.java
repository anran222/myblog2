package lianxi;

import java.util.Scanner;

public class NumberTowerProblem {
    public static void main(String[] args) {
        System.out.println("请输入行数：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] num=new int[n+2][n+2];
        int[][] max=new int[n+2][n+2];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                num[i][j]=sc.nextInt();
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
              num[i][j]=Math.max(num[i-1][j-1]+num[i][j],num[i-1][j]+num[i][j]);
            }
        }
        int max1=0;
        for (int i = 1; i <=n+1 ; i++) {
            max1=Math.max(num[n][i],max1);
        }
        System.out.println(max1);
    }
}
