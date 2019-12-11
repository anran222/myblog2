
package caozuoxitong2;
import java.util.Scanner;

public class CaoZuoXiTong2 {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	Thread course[]=new Thread[8];
	System.out.println("请输入进程数目（5~8个）");
	int N=scanner.nextInt();
	for(int i=0;i<N;i++)              //节点初始化
	{
		course[i]=new Thread();
	}
	
	for(int i=0;i<N;i++)
	{
		//System.out.println("请输入"+(i+1)+"个进程的进程名");
		course[i].name=i+1;
		//System.out.println("请输入"+(i+1)+"个进程的等待时间");
		course[i].runTime=(int)(Math.random()*10+1);
		//System.out.println("请输入"+(i+1)+"个进程的执行时间");
		course[i].priority=(int)(Math.random()*20+1);
	}
	System.out.println("\t节点生成完成\n\t节点信息为");
	Print(course,N);
	System.out.println("\t请选择所采用的调度算法");
	System.out.println("\t1优先权法\t2轮转法");
	int choose=scanner.nextInt();
	while(choose!=1&&choose!=2)
	{
		System.out.println("\t请输入有效选项");
		choose=scanner.nextInt();
	}
	switch (choose) {
	case 1:
		P(course,N);
		break;
	case 2:
		L(course,N);
	default:
		break;
	}
	

	
	
 }

   public static void Print(Thread course[],int N) {
	   System.out.println("\t进程名\t进程所需运行时间 \t进程优先级       ");
	   for(int i=0;i<N;i++)
		{
		   
			System.out.println("\t"+course[i].name+"\t"+course[i].runTime+"\t\t"+course[i].priority);
		}
   }
   
   public static void Prints(Thread course[],int N) {
	   System.out.println("\t进程名\t 进程所需运行时间\t");
	   for(int i=0;i<N;i++)
		{
		   if(course[i].runTime>0)
			System.out.println("\t"+course[i].name+"\t"+course[i].runTime);
		}
   }

   public static void P(Thread course[],int N)
   {
	   int flag[]=new int [N];  //定义一个标记
	   for(int i=0;i<N;i++)  //标记初始化
	   {
		   flag[i]=1;
	   }
	   
	   int m=1;
	   while(true)
	   {
		   int sum=0;
		   for(int i=0;i<N;i++)
		   {
			   sum+=flag[i];
		   }
		   
		   if(sum==0)  //即所有进程都完成
		   {
		
			   System.out.println("\t所有进程执行完毕");
		       break;
			   
		   }
			   
		   
		   System.out.println("-------------执行第"+m+"次调度------------------");
		   m++;
		   int flage=seachMax(course, N,flag);
		   System.out.println("\t本次执行的程序为:"+course[flage].name+"号进程");
		   course[flage].runTime--;
		   course[flage].priority=course[flage].priority-3;
		   if(course[flage].runTime==0)
		   {
			   flag[flage]=0;
			   course[flage].priority=-Integer.MAX_VALUE;
		   }
			   
		   System.out.println("\t调度后的进程参数为：");
		   
		   Print(course, N);
		   
		   if(course[flage].runTime==0)
			   System.out.println("进程"+course[flage].name+"结束");
		  
	   }   
   }
   
   
   
   public static void L(Thread course[],int N)
   {
	   int M=N;
	   System.out.println("采用的进程调度方法为时间片轮转法");
	   System.out.println("时间片设定为4");
	   int flag[]=new int [N];  //定义一个标记
	   for(int i=0;i<N;i++)  //标记初始化
	   {
		   flag[i]=1;
	   }
	   
	   int m=1;
	   int count=0;
	   
	   while(true)
	   {
		   
		   int sum=0;
		   for(int i=0;i<N;i++)
		   {
			   sum+=flag[i];
		   }
		   
		   if(sum==0)  //即所有进程都完成
		   {
		
			   System.out.println("------所有进程执行完毕-------");
		       break;
			   
		   }
			   
		   
		   System.out.println("-------------执行第"+m+"次调度------------------");
		   m++;
		   System.out.println("\t调度后的进程参数为：");
		   if(M<=4)
		   {
			   for(int i=0;i<N;i++)
			   {
				   if(course[i].runTime!=0)
				   {
					   course[i].runTime--;
					   
					   if(course[i].runTime==0)
					   {
						   flag[i]=0;
						   System.out.println("进程"+course[i].name+"结束");
					   }
					   
				   }   
			   }
			   Prints(course, N);
		   }else if(M>4){
				   for(int i=0;i<4;i++)
				   {
					   course[count].runTime--;
					   if(course[count].runTime==0)
					   {
						   flag[count]=0;
						   System.out.println("进程"+course[count].name+"结束");
						   M--;
					   }
					   count++;
					   if(count==N)
						   count=0;
				   }
			   Prints(course, N);
		   }
		   
	   }
	   
   }
   
   public static int seachMax(Thread course[],int N,int flag[])  //寻找优先权最大的进程号
   {
	   int flage=Integer.MAX_VALUE;
	   int max=-Integer.MAX_VALUE;
	   for(int i=0;i<N;i++)
	   {
		   if(course[i].priority>max&&flag[i]==1)
		   {
			   max=course[i].priority;
			   flage=i;
		   }
	   }
	   
	   return flage;
   }
   
   static class Thread
   {
   	int name;
   	int runTime;
   	int priority;
   	public void Thread()
   	{
   	}
   }
   
}
