package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] a = new int[n];
		String[] input = br.readLine().split(" ");
		int result = 0;
		// 수열 값 입
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(input[i]);
		}

		for(int i=0;i<n;i++) {
			dp[i] = 1;// 기본적으로 1인데,수열 1개만 있어도 만족하는 길이는 1이되기떄문.
			for(int j=0; j<i;j++) {//i 보다 이전애들만 비교 ,j는 i번쨰 보다 앞에 있는 애들이기때문에 j<i조건 
				if(a[i]>a[j] && dp[i]<dp[j]+1 ) { 
					/*
				 	 *a[i]는 a[j] 보다 커야하고,(작으면 증가 하는 것이 아니니 비교할 필요가 없음)
				 	 *dp[i]는 현재 1 이고, 루프 돌면서 값이 계속 변함.
				 	 *그런데 저 조건을 빼버리면 루프를 돌면서 결국 맨 첫번째값보다 1큰값 들어가게됨.
				 	 * 그래서 값을 갱신해 주면서 비교할 값보다 1 큰 값인지 비교를 해줘야함. 
				 	 * +1을 해주지 않으면 계속 1과 1을 비교하기 때문에 길이가 갱신 되지 않아 무의미한 조건이 되버린다.
					 */	
					dp[i] = dp[j]+1;
				}
			}
		}
		result = dp[0];
		for(int i=0; i<n;i++) {
			if(result < dp[i]) {
				result = dp[i];
			}
		}
		System.out.println(result);
	}

}
