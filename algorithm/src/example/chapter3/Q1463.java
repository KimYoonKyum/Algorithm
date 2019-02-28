package example.chapter3;

import java.util.Scanner;

public class Q1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[1] = 0;
		
		for(int i=2; i<=n;i++) {
			// n-1 case
			dp[i] = dp[i-1] + 1;
			
			// n/2 case
			if(i%2 == 0 && dp[i] > dp[i/2]+1) {
				dp[i] = dp[i/2] + 1;
			}
			
			// n/3 case
			if(i%3 == 0 && dp[i] > dp[i/3]+1) {
				dp[i] = dp[i/3] + 1;
			}
		}
		System.out.println(dp[n]);
	}
}
