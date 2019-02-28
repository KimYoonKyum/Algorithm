package example.chapter3;

import java.util.Scanner;

public class Q9095 {
	static int[] dp = new int[12];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0) {
			int n = sc.nextInt();
			
			for(int i=4; i<=11; i++) {
				/*
				 * o+o+ ****** + o = n이 되므로
				 *an 자리에는 1,2,3의 숫자가 올수있다.
				 *그러면 뒤에 1이 오는 경우는 n에서 1을 뺴는 것이기 때문
				 * 마지막에 1이 오는 경우의 1 이전지의 합은 dp[n-1]이 된다.
				 * 이런식으로 2와 3을 생각하면 아래와 같은 점화식이 나온다.
				 */
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
			}
			System.out.println(dp[n]);
			T--;
		}
	}

}
