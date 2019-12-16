package decomposingprimefactor;

import java.util.Scanner;

public class DecomposingPrimeFactor {
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       int a=input.nextInt();
       int b=input.nextInt();
       for(int i=a;i<=b;i++)
       {
       System.out.print(i+"=");
       int temp=i;
       for(int j=2;j<=temp;j++)
       {
           while(temp%j==0&&temp!=j)
           {
               temp=temp/j;
               System.out.print(j+"*");
           }
           if(temp==j)
           {
               System.out.print(j);
               break;
           }
       }
       System.out.println();
    }
    }
}
