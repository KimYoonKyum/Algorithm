package example.chapter4;

import java.util.Scanner;

public class Q1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int result = n/5;
		int temp =5;
		for(int i=1; i<=2;i++) {
			temp *= 5;
			result +=(n / temp);
		}
		System.out.println(result);
	}

}
