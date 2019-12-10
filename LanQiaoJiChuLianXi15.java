
package lanqiaojichulianxi15;
import java.util.Scanner;
public class LanQiaoJiChuLianXi15 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s1=input.next();
        String s2=input.next();
        if(s1.length()!=s2.length())
        {
            System.out.println(1);
        }
        if(s1.length()==s2.length())
        {
            if(s1.equals(s2))
            {
                System.out.println(2);
            }
            else if(s1.toUpperCase().equals(s2.toUpperCase()))
            {
                System.out.println(3);
            }
            else
            {
                System.out.println(4);
            }
        }
    }
    
}
