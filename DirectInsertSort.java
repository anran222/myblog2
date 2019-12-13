
package directinsertsort;
public class DirectInsertSort {
     public static void main(String[] args) {
         int[] a={12,34,5,62,20,45,32};
         for(int i=1;i<a.length;i++)
         {
            if(a[i]<a[i-1])
            {
                int count=a[i];
                int j=i-1;
                for(;j>=0&&count<a[j];j--)
                {
                    a[j+1]=a[j];
                }
                a[++j]=count;
            }
         }
         for(int i=0;i<a.length;i++)
         {
             System.out.println(a[i]);
         }
    }
}

