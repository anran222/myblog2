
package lanqiaojichulianxi14;

import java.util.Scanner;

public class LanQiaoJiChuLianXi14 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long n=input.nextInt();
        long num1=0;
        long num2=0;
        long num3=0;
             num1=n/3600;
            num2=(n%3600)/60;
            n=(n%60)%60;
        System.out.println(num1+":"+num2+":"+n);
    }
    
}
