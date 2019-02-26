package example.chapter1;

import java.util.Scanner;

public class Q2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//print 함수는 println 함수와 다르게 개행을 하지 않음.
}
