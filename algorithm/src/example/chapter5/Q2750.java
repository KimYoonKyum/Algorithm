package example.chapter5;

import java.util.Scanner;

public class Q2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i=0; i<n;i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<n;i++) {
			for(int j=i+1; j<n;j++) {
				if(num[j] < num[i]) {
					int temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
			}
		}
		
		for(int i=0; i<n;i++) {
			System.out.println(num[i]);
		}
	}

}
