import  java.util.*;  
  
public class QueensProblem  
{  
    static int n,count=0;                  //n表示棋盘的大小，count则为上文提到的计数变量记录放置方法的个数
    static int map[][];                    //二维数组表示棋盘
    public static void main(String args[])  
    {  
        Scanner cn=new Scanner(System.in);  
        n=cn.nextInt();                    //相关变量的录入 
        map=new int[n][n];  
        for(int i=0;i<n;i++)               //棋盘具体值的录入（0或1）
            for(int j=0;j<n;j++)  
                map[i][j]=cn.nextInt();  
        Put(0,2);                          //从第一行开始进行白皇后的放置，2代表白，3代表黑
        System.out.println(count);         //当所有的方法都寻找完成后，输出找到的方法个数
    }  
    public static void Put(int t,int s)    //放置皇后的函数
    {  
        if(t==n)                           //进行当前类型皇后的放置数量是否达到要求，即是否到了棋盘的最后一行
        {  
            if(s==2)Put(0,3);              //如果白皇后放置成功，则进行黑皇后的放置
            else count++;                  //放置方法招到了一种，计数变量进行值加一
            return ;                       //当前整体放置过程结束，进行程序的回溯
        }  
        for(int i=0;i<n;i++)               //对每一行的值逐个进行操作
        {             
            if(map[t][i]!=1)continue;      //当前位置是否为1的判断
            if(Check(t,i,s)){map[t][i]=s;} //是否满足题目要求判断，满足赋值
            else continue;                 //不满足，同一行的下一个位置
            Put(t+1,s);                    //下一行皇后的放置
            map[t][i]=1;                   //回溯法的关键      
        }  
        return ;                           //进行相应的回溯
    }  
    public static boolean Check(int t,int i,int s)   //满足题目要求的判断函数
    {  
        for(int q=t-1;q>=0;q--)                      //当前位置上方是否进行了相同皇后的放置 这行以下的还没放不检查  
        {  
            if(map[q][i]==s)return false;  
        }         
        for(int q=t-1,w=i-1;q>=0&&w>=0;q--,w--)      //检查左对角线 这行以下的还没放不检查  
        {  
            if(map[q][w]==s)return false;  
        }  
        for(int q=t-1,w=i+1;q>=0&&w<=n-1;q--,w++)    //检查右对角线 这行以下的还没放不检查  
        {  
            if(map[q][w]==s)return false;  
        }  
        return true;                                 //都满的情况下，则可以进行当前皇后的放置
    }  
}  