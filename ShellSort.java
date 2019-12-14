package shellsort;
public class ShellSort {
    public static void main(String[] args) {
        int[] a={46,55,13,42,94,17,05,70};
        int delta=a.length;
        while(delta!=0)
        {
            delta=delta/2;
            for(int i=delta;i<a.length;i++)
            {
                int count=a[i];
                  int j=i-delta;
                  for(;j>=0&&count<a[j];j-=delta)
                  {
                      a[j+delta]=a[j];
                  }
                  a[j+delta]=count;
              }
         }
        for(int i=0;i<a.length;i++)
        {
        System.out.println(a[i]);
        }
    }
}
