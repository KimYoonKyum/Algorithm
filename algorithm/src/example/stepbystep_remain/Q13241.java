package example.stepbystep_remain;
import java.util.*;
public class Q13241 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long gcd = gcd(a,b);
		System.out.println((a*b)/gcd);
	}
	private static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
}
