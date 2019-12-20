package divisionofnumbers;
import java.util.Scanner;
public class DivisionOfNumbers {
    public static void main(String[] args) {
       int [][]dp=new int[201][201];
        int n,k;
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        k=input.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-j][j]+dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
