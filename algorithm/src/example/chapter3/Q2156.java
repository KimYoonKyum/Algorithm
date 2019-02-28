package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		long[] amount = new long[n+1];
		
		for(int i=1; i<=n;i++) {
			amount[i] = Long.parseLong(br.readLine());
		}
		
		if(n>=1) {
			dp[1] = amount[1];
		}
		if(n>=2) {
			dp[2] = amount[1] + amount[2];
		} 
		if(n>=3){
			for(int i=3; i<=n;i++) {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+amount[i], dp[i-3]+amount[i]+amount[i-1]));
			}
		}
		System.out.println(dp[n]);
	}

}
