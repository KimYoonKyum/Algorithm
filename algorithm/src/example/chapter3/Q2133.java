package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2133 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 0;
		/*
		 * 틀렸던 이유 :
		 * 1.n이 홀수인 경우는 완벽하게 채울 수 없기 때문에 초기 값을 0으로 해놓아야 한다.
		 * 2.마지막에 올 수 있는 경우를 길이를 2로만 생각했다.4,6,8 등이 올 수 있는 것을 고려 하지못함.
		 */
		for(int i=2; i<=n;i++) {
			dp[i] = dp[i-2]*3;
			for(int j=4;i-j>=0;j+=2) {
				dp[i] += (2 *dp[i-j]);
			}
		}
		System.out.println(dp[n]);
	}

}
