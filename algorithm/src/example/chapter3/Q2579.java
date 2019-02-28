package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][3]; 
		long[] score = new long[n+1];
		for(int i=1; i<=n; i++) {
			score[i] = Long.parseLong(br.readLine()); 
		}
		
		if(n>=1) {
			dp[1][1] = score[1];
			dp[1][2] = 0;
		}
		
		for(int i=2; i<=n;i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + score[i];
			dp[i][2] = dp[i-1][1] + score[i];
		}
		
		long result = Math.max(dp[n][1], dp[n][2]);
		System.out.println(result);
	}

}
