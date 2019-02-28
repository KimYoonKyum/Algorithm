package example.chapter3;

import java.util.Scanner;

public class Q2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/*
		 * int 형으로 배열을 선언하면 n이 90 인 경우 int 형 범위를 초과하기 때문long으로 선언해줘야한다.
		 */
		long[] dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
