package example.stepbystep_remain;

import java.util.*;
public class Q1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int gcd = gcd(n,m);
			System.out.println((n*m)/gcd);
		}
	}
	/*
	 * 유클리드 호제법을 사용해서 최대공약수 구함.
	 * 두수의 곱에 최대공약수로 나누면 최소 공배수가 나옴.
	 */
	private static int gcd(int a, int b) {
		if(b==0) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}

}
