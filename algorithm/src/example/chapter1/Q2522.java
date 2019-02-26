package example.chapter1;

import java.util.Scanner;

public class Q2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			String result = "";
			for(int k=1; k<=N-i; k++) {
				result += " ";
			}
			for(int j=1; j<=i;j++) {
				result += "*";
			}
			System.out.println(result);
		}
		
		for(int i=N-1;i>=1;i--) {
			String result = "";
			for(int k=1; k<=N-i; k++) {
				result += " ";
			}
			for(int j=1; j<=i;j++) {
				result += "*";
			}
			System.out.println(result);
		}
	}
}
