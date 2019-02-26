package example.chapter1;

import java.util.Scanner;

public class Q10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, a, b;
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
	}
}
