package example.chapter3;

import java.util.Scanner;

public class Q11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10];
		int mod = 10007;
		
		for(int i=0;i<=9;i++) {
			dp[1][i] = 1;
		}
		
		/*
		 * dp[n][i] = n자리,i로끝나는 경우
		 * 끝에 0부터 9까지 숫자가 올 수 있음. 끝 바로 전 자리는 k가 올 수 있(k는 끝자리보다 같거나 큰수)
		 */
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0; k<=j;k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= mod;
				}
			}
		}
		int result = 0;
		for(int i=0; i<=9;i++) {
			result += dp[n][i];
		}
		System.out.println(result%mod);
	}

}
