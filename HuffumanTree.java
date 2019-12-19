package huffumantree;
import java.util.Scanner;
public class HuffumanTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int sum = 0;
		for (int k = 1; k < a.length; k++) {
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					int t = 0;
					if (a[j] > a[j + 1]) {
						t = a[j];
						a[j] = a[j + 1];
						a[j + 1] = t;
 
					}
 
				}
 
			}
			a[k] = a[k - 1] + a[k];
			//System.out.println(a[k]);
			sum += a[k];
			a[k - 1] = 0;
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					int t = 0;
					if (a[j] > a[j + 1]) {
						t = a[j];
						a[j] = a[j + 1];
						a[j + 1] = t;
 
					}
 
				}
 
			}
		}
 
		System.out.println(sum);
	}
 
}
