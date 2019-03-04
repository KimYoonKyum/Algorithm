package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[][] dp = new int[n+1][k+1];
		dp[0][0] = 1;
		for(int i=0;i<=k;i++) {
			dp[0][i] = 1;
		}
		
		for(int x=1; x<=n;x++) {
			for(int y=1; y<=k;y++) {
				for(int z=0; z<=x;z++) {
					dp[x][y] += dp[x-z][y-1];
					dp[x][y] %= 1000000000;
				}
			}
			
		}
		System.out.println(dp[n][k]);
	}

}
