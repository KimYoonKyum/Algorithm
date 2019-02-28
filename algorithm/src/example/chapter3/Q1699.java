package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		int[] dp = new int[n+1];
		/*
		 * dp[i]는 여러항으로 구성되면서 마지막 항에는 1의제곱부터 i의 제곱까지 값이 올 수 있다.
		 * 그러므로 마지막 항을 제외한 그 앞에 항은 dp[n-i^2] 값 중의 최소값임을 알 수 있다.
		 * 거기에 1제곱 부터 i제곱까지 항 하나를 더해주기 때문에 dp[n-i^2] +1을 한 값이 최소가
		 * 되는 값이 정답이 된다. 
		 */
		for(int i=1; i<=n;i++) {
			dp[i] = i;
			for(int j=1; j*j <= i;j++) {
				if(dp[i]> dp[i-j*j]+1) {
					dp[i] = dp[i-j*j]+1;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
