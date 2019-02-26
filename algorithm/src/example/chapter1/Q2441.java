package example.chapter1;

import java.util.Scanner;

public class Q2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		for(int i=N;i>=1;i--) {
			String result ="";
			for(int k=1; k<=N-i;k++) {
				result += " ";
			}
			for(int j=i; j>=1; j--) {
				result += "*";
			}
			System.out.println(result);
		}
	}
}
