package binaryinsertionsort;
public class BinaryInsertionSort {
    public static void main(String[] args) {
        int []a={12,34,5,62,20,45,32};
        for(int i=1;i<a.length;i++)
        {
            int x=a[i];
            int low=0;
            int high=i-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(x<a[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            for(int j=i-1;j>=low;j--)
            {
                a[j+1]=a[j];
            }
                a[low]=x;
        }
        for(int i=0;i<a.length;i++)
        {
        System.out.println(a[i]);
    }
    }
}
