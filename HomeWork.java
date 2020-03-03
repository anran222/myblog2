package bithomework;

/**
 * @Author:xiang
 * @Date:2020/3/3 22:55
 */
public class HomeWork {
    public static void main(String[] args) {
//        array(100);
        int[] array={1,2,3,4,5,6,7};
//        transform(array);
//        printArray(array);
//        System.out.println(sum(array));
        System.out.println(avg(array));
    }

    public static void array(int n){
        int[] arr=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }
    }

    public static void printArray(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }


    public static void transform(int[] array){
        for (int i = 0; i <array.length ; i++) {
            array[i]=array[i]*2;
        }
    }

    public static int sum(int[] array){
        int sum=0;
        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }
        return sum;
    }

    public static double avg(int[] array){
        int sum=0;
        for (int i = 0; i <array.length ; i++) {
            sum+=array[i];
        }
        double avgs=sum/array.length;
        return avgs;
    }
}
