import java.math.BigDecimal;
import java.util.Scanner;
public class HighPrecisionAddtion{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigDecimal num1=sc.nextBigDecimal();
        BigDecimal num2=sc.nextBigDecimal();
        BigDecimal num3=num1.add(num2);
        System.out.println(num3); 
    }
}