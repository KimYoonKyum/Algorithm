package example.stepbystep_remain;
import java.util.*;
public class Q11066 {
	static int[][] dp;
	static int[] a;
	static int[] sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n-- > 0) {
			int k = sc.nextInt();
			dp = new int[k+1][k+1];
			a = new int[k+1];
			sum = new int[k+1];
			for(int i=1; i<=k; i++) {
				a[i] = sc.nextInt();
			}
			for(int i=1; i<=k;i++) {
				sum[i] = sum[i-1] + a[i];
			}
			for(int i=1; i<=k;i++) {
				for(int j=1;j<=k;j++) {
					dp[i][j] = -1;
				}
			}
			
			System.out.println(solve(1,k));
		}
		
	}

	/*
	 * dp[i][j]는 i번째장 부터 j번째 장까지의 최소합
	 * 40 30 30 50 은 이렇게 나눌 수 있다. [40 / 30 30 50], [40 / (30) (30 50)] ... 
	 * 그러니깐 시작점 중간점 끝점을 잡고 i번째부터 mid번째까지 의 dp를 구하고 mid+1번째 부터 j까지 dp를 구하고 +sum[i~j](왜냐면 결국 마지막에는 모든 장수를 합쳐야 하니 저 값이 필요) 의
	 * 최소 값을 찾으면 된다.
	 * dp[i][k]+dp[k+1][j] 의 식으로 mid 값인 k는 중간을 자리는 위치 만큼 반복해야한다. 그래서 3중 for문이 되야한다.
	 *
	 */
	private static int solve(int start, int end) {
		if(start >= end) {
			return 0;
		}
		if(dp[start][end] != -1) {
			return dp[start][end];
		}
		if(start+1 == end) {
			return a[start]+a[end];
		}
		
		dp[start][end] = Integer.MAX_VALUE;
		
		for(int i=start; i<=end;i++) {
			int tmp = solve(start,i) + solve(i+1,end) + sum[end]-sum[start-1];
			dp[start][end] = Math.min(dp[start][end], tmp);
		}
		return dp[start][end];
	}

}
