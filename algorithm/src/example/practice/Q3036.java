package example.practice;
import java.util.*;
public class Q3036 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[100];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			a[i] = 2*a[i];
			if(i != 0) {
				int gcd = gcd(a[0],a[i]);
				System.out.println((a[0]/gcd)+"/"+(a[i]/gcd));
			}
		}
		
	}
	private static int gcd(int a, int b) {
		if( b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}

}
