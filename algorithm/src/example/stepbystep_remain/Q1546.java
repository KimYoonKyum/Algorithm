package example.stepbystep_remain;
import java.util.*;
public class Q1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] s = new int[n];
		for(int i=0;i<n;i++) {
			s[i] = sc.nextInt();
		}
		Arrays.sort(s);
		int m = s[n-1];
		int sum = 0;
		for(int i=0; i<n;i++) {
			sum += s[i];
		}
		System.out.println(sum*((float)100/(m*n)));
	}

}
