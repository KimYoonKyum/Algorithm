package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] a = new int[n];
		String[] input = br.readLine().split(" ");
		int result = 0;
		// 수열 값 입
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(input[i]);
		}

		for(int i=0;i<n;i++) {
			dp[i] = a[i];
			for(int j=0; j<i;j++) { 
				if(a[i]>a[j] && dp[i]<dp[j]+a[i] ) { 
					dp[i] = dp[j]+a[i];
				}
			}
		}
		result = dp[0];
		for(int i=0; i<n;i++) {
			if(result < dp[i]) {
				result = dp[i];
			}
		}
		System.out.println(result);
	}
}
