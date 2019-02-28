package example.chapter3;

import java.util.Scanner;

public class Q11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0] = 1; // 없는 상태이지만 결국 2*1 과 2*2도 없는 상태에 도형을 붙인 것으로 이해하면 더 편함.
		dp[1] = 1;
		for(int i=2; i<=n;i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}
