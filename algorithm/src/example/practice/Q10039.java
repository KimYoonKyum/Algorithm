package example.practice;
import java.util.*;
public class Q10039 {
	static final int N = 5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[N];
		int sum = 0;
		for(int i=0; i<N;i++) {
			int input = sc.nextInt();
			if(input < 40) {
				input = 40;
				score[i] = input;
			} else {
				score[i] = input;
			}
			sum += input;
		}
		System.out.println(sum/N);
	}

}
