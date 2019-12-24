import java.util.Arrays;

public class Main {
    public static void bubbleSort(int array[]){
        int n=array.length;
        for(int i=0;i<n-1;i++){
            boolean swap=false;
            for(int j=0;j<n-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swap=true;
                }
            }
            if (!swap){
                break;
            }
        }
    }
    public static void main(String[] arg){
        int[] array={32,54,1,23,56,14,78};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}