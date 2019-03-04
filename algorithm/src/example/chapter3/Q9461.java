package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			for(int i=6;i<=n;i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			System.out.println(dp[n]);
		}
	}

}
