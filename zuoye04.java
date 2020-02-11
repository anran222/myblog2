package zuoye;

import java.util.Arrays;

/**
 * @Author:xiang
 * @Date:2020/2/11 21:26
 */
public class zuoye04 {
    public static void main(String[] args) {
//        String s = "h";
//        int num=lengthOfLastWord(s);
//        System.out.println(num);
        int[] nums1={1,2,4,7,9};
        int[] nums2={3,4,5,6,7};
        merge(nums1,5-1,nums2,5);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
         System.arraycopy(nums1,m-1,nums2,0,n);
        Arrays.sort(nums1);
    }


    public static int lengthOfLastWord(String s) {
        if (s.length()==0){
            return 0;
        }
        char[] a = s.toCharArray();
        int end = a.length - 1;
        int num = 0;
        if (end==0&&a[end]==' '){
            return 0;
        }
        if (a[end] == ' ') {
            num = 0;
        } else {
            for (int i = end; i >= 0; i--) {
                if (a[i] == ' ') {
                    num = end-i;
                    break;
                }else{
                    num++;
                }
            }
        }
        return num;
    }
}