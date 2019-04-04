package example.practice;
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
	 * dp[i][j]�� i��°�� ���� j��° ������� �ּ���
	 * 40 30 30 50 �� �̷��� ���� �� �ִ�. [40 / 30 30 50], [40 / (30) (30 50)] ... 
	 * �׷��ϱ� ������ �߰��� ������ ��� i��°���� mid��°���� �� dp�� ���ϰ� mid+1��° ���� j���� dp�� ���ϰ� +sum[i~j](�ֳĸ� �ᱹ ���������� ��� ����� ���ľ� �ϴ� �� ���� �ʿ�) ��
	 * �ּ� ���� ã���� �ȴ�.
	 * dp[i][k]+dp[k+1][j] �� ������ mid ���� k�� �߰��� �ڸ��� ��ġ ��ŭ �ݺ��ؾ��Ѵ�. �׷��� 3�� for���� �Ǿ��Ѵ�.
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
