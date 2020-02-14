package zuoye;

import java.util.Arrays;
import java.util.Collection;
import java.util.SplittableRandom;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

/**
 * @Author:xiang
 * @Date:2020/2/14 20:26
 */
public class zuoye06 {
    public static void main(String[] args) {
//           int[] a={-4,-1,0,3,10};
//           int[] b=sortedSquares(a);
//        System.out.println(Arrays.toString(b));

         String s="test1ng-leet==code-q!";
         String ss=reverseOnlyLetters(s);
        System.out.println(ss);
    }

    public static int[] sortedSquares(int[] A) {
        int n=A.length;
        int[] B=new int[n];
        for (int i = 0; i <A.length ; i++) {
            B[i]=A[i]*A[i];
        }
        Arrays.sort(B);
        return B;
    }

    public static String reverseOnlyLetters(String S) {
        char[] a=S.toCharArray();
        int m=0;
        int n=a.length-1;
        while(m<=n){
            if (!isLetter(a[m])){
                m++;
            }else if (!isLetter(a[n])){
                    n--;
            }else{
                char temp=a[m];
                a[m]=a[n];
                a[n]=temp;
                m++;
                n--;
            }
        }
        return String.valueOf(a);
    }
}
