package example.practice;

import java.util.*;

public class Q1850 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long gcd = gcd(a,b);
		StringBuilder sb = new StringBuilder();
		for(long i=1; i<=gcd;i++) {
			sb.append("1");
		}
		System.out.println(sb);
		
	}
	
	private static long gcd(long a, long b) {
		if(b == 0){
			return a;
		}
		
		return gcd(b, a%b);
	}

}
