package zuoye;

import java.util.Arrays;

/**
 * @Author:xiang
 * @Date:2020/2/15 20:36
 */
public class zuuoye07 {
    public static void main(String[] args) {
//        int[] a={3,1,2,4};
//        System.out.println(Arrays.toString(sortArrayByParity(a)));
        int[] a={1,7,3,6,5,6};
        System.out.println(pivotIndex(a));
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] B=new int[A.length];
        int[] C=new int[A.length];
        int m=0;
        int n=0;
        for (int i = 0; i <A.length ; i++) {
            if(A[i]%2==0){
                B[m]=A[i];
                m++;
            }else {
                C[n]=A[i];
                n++;
            }
        }
        System.arraycopy(C,0,B,m,n);
        return B;
    }

    public static int pivotIndex(int[] nums) {
        int sum=0;
        int sum1=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        for (int i = 0; i <nums.length ; i++) {
            if (sum1==sum-sum1-nums[i]){
                return i;
            }
            sum1+=nums[i];
        }
        return -1;
    }
}
