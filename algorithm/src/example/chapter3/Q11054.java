package example.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] asc_dp = new int[n];
		int[] desc_dp = new int[n];
		int[] a = new int[n];
		String[] input = br.readLine().split(" ");
		int result = 0;
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0;i<n;i++) {
			asc_dp[i] = 1;
			for(int j=0; j<i;j++) { 
				if(a[i]>a[j] && asc_dp[i]<asc_dp[j]+1 ) { 
					asc_dp[i] = asc_dp[j]+1;
				}
			}
		}

		for(int i=n-1;i>=0;i--) {
			desc_dp[i] = 1;
			for(int j=i+1; j<n;j++) { 
				if(a[i]>a[j] && desc_dp[i]<desc_dp[j]+1 ) { 
					desc_dp[i] = desc_dp[j]+1;
				}
			}
		}
		
		
		for(int i=0; i<n;i++) {
			if(result < asc_dp[i]+desc_dp[i]-1)
				result= asc_dp[i]+desc_dp[i]-1;
		}
		
		System.out.println(result);
		
	}

}
