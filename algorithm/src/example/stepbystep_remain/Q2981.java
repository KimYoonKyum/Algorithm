package example.stepbystep_remain;
import java.util.*;
public class Q2981 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int gcd = a[0];
		for(int i=1; i<n;i++) {
			gcd = gcd(a[i],gcd);
		}
		
		for(int i=0; i<n;i++) {
			a[i] /= gcd;
			System.out.println(a[i]);
		}
	}
	
	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}

}
