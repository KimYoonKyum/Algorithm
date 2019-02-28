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
		 * dp[i]�� ���������� �����Ǹ鼭 ������ �׿��� 1���������� i�� �������� ���� �� �� �ִ�.
		 * �׷��Ƿ� ������ ���� ������ �� �տ� ���� dp[n-i^2] �� ���� �ּҰ����� �� �� �ִ�.
		 * �ű⿡ 1���� ���� i�������� �� �ϳ��� �����ֱ� ������ dp[n-i^2] +1�� �� ���� �ּҰ�
		 * �Ǵ� ���� ������ �ȴ�. 
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
