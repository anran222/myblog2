import java.util.Scanner;
public class Test{
    public static int Sum(int n){
        if(n<=9){
            return n;
        }
        return n%10+Sum(n/10);
    }
    public static void Print(int n){
        if(n>9){
            Print(n/10);
        }
        System.out.print(n%10+"+");
    }
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=n;
        int num=n%10;
        n=n/10;
        int result=Sum(m);
        System.out.print(m+"->");
        Print(n);
        System.out.print(num);
        System.out.print("="+result);
    }   
    }

