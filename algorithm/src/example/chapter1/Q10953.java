package example.chapter1;

import java.util.Scanner;

public class Q10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,a,b;
		String input;
		String[] inputArray;
		
		T = sc.nextInt();
		for(int i=0;i<T;i++) {
			input = sc.next();
			inputArray = input.split(",");
			a = Integer.parseInt(inputArray[0]);
			b = Integer.parseInt(inputArray[1]);
			System.out.println(a+b);
		}
	}
}
