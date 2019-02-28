package example.chapter3;

import java.util.Scanner;

public class Q10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10];
		
		/*
		 * 초기화 
		 * dp[1]인 경우 1부터 9까지 숫자 들어올 수 있음.
		 */
		dp[1][0] = 0;
		for(int i=1; i<=9;i++) {
			dp[1][i] = 1;
		}
		
		/*
		 * dp[n][i] = dp[n-1][i-1] + dp[n-1][i+1]
		 * 여기서 0은 1, 9는 8과 차이가 1나므로 예외처리를 해줘야한다.
		 */
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				if(j==9) {
					dp[i][j] = dp[i-1][8];
				} else if(j==0) {
					dp[i][j] = dp[i-1][1];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
				dp[i][j] %= 1000000000;
			}
		}
		long result = 0;
		for(int i=0; i<=9;i++) {
			result += dp[n][i];
		}
		System.out.println(result%1000000000);
	}

}
