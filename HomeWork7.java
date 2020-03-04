package bithomework;

import java.util.Arrays;

/**
 * @Author:xiang
 * @Date:2020/3/4 21:53
 */
class HomeWork7 {
    public static void main(String[] args) {
//        int[] a={1,2};
        int[] b={1,2,3,4,5,6};
//        swap(a,b);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
        jiOu(b);


//        System.out.println(new HomeWork7());
//    }
//        public String toString(){
//            System.out.print("aaa");
//            return "bbb";
//    }
    }

    public static void swap(int[] a,int[] b){
        int m=a.length;
        int n=b.length;
        int temp;
        for (int i = 0; i <m ; i++) {
                temp=a[i];
                a[i]=b[i];
                b[i]=temp;
        }
    }

    public static void jiOu(int[] a){
        int m=a.length;
        int j=0;
        int k=0;
        int[] b=new int[m];
        int[] c=new int[m];
        for (int i = 0; i <m ; i++) {
            if (a[i]%2==0){
                b[j]=a[i];
                j++;
            }else {
                c[k]=a[i];
                k++;
            }
        }
        for (int i = 0; i <j ; i++) {
            System.out.print(b[i]);
        }
        for (int i = 0; i <k ; i++) {
            System.out.print(c[i]);
        }
    }
}
