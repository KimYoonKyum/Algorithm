package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n];
		long[] a = new long[n];
		String[] input = br.readLine().split(" ");
		long result = 0;
		
		for(int i=0;i<n;i++) {
			a[i] = Long.parseLong(input[i]);
		}
		result = a[0];
		for(int i=0;i<n;i++) {
			dp[i] = a[i];//a[i]로 연속합을 시작하는경우로 미리 세팅(이전 연속합들과 비교하기 위해서)
			
			if(i==0) continue;
			if(dp[i-1]+a[i]> dp[i]) {
				/*
				 *  a[i]로 연속합이 끝나는 경우는 두가지 경우가 있다.
				 *  1. a[i-1]로 끝나는 연속합에 a[i]를 마지막에추가한 경우
				 *  2. a[i]로 시작하는 연속합
				 *  이 두개를 비교하면서 결과를 찾아가면 된다.
				 */
				dp[i] = dp[i-1]+a[i];
			}
			result = Math.max(dp[i],result);
		}
		
		System.out.println(result);
	}

}
