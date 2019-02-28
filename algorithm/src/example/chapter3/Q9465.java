package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[][] dp = new long[n+1][3];
			long[][] score = new long[2][n];
			
			//input score
			String[] input = br.readLine().split(" ");
			for(int i=0; i<n;i++) {
				score[0][i] = Integer.parseInt(input[i]);
			}
			input = br.readLine().split(" ");
			for(int i=0; i<n;i++) {
				score[1][i] = Integer.parseInt(input[i]);
			}
			
			//calculate
			for(int i=1; i<=n;i++) {
				dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + score[0][i-1];
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + score[1][i-1];
			}
			
			long result = Math.max(Math.max(dp[n][0], dp[n][1]),dp[n][2]);
			System.out.println(result);
		}
	}
}
