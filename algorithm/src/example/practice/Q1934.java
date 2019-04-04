package example.practice;

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
	 * ��Ŭ���� ȣ������ ����ؼ� �ִ����� ����.
	 * �μ��� ���� �ִ������� ������ �ּ� ������� ����.
	 */
	private static int gcd(int a, int b) {
		if(b==0) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}

}
