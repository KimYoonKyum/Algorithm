package example.chapter1;

import java.util.Scanner;
public class Q10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int input,min = 1000000,max = -1000000;
		
		for(int i=1; i<=N; i++) {
			input = sc.nextInt();
			if(input > max) max = input;
			if(input < min) min = input;
		}
		System.out.println(min + " " + max);
	}
}
