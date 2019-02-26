package example.chapter1;

import java.util.Scanner;

public class Q2558 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b;
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(!(a > 0 && a < 10)) {
			return;
		}
		
		if(!(b > 0 && b < 10)) {
			return;
		}
		System.out.println(a+b);
	}
}
