package example.chapter3;

import java.util.Scanner;

public class Q2011 {
	static final int mod = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		int n = s.length();
		s = " "+s; // 문자열 인덱스 1부터 계산하기 위해
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			int x = s.charAt(i) - '0'; // 문자를 숫자로
			// 마지막 자리가 1자리수 일때 
			if( x>=1 && x<= 9) {
				dp[i] += dp[i-1];
				dp[i] %= mod;
			}
			
			if(i==1) continue; // 한자리 일때  
			if(s.charAt(i-1) == '0') continue; // 문자열에 첫쨰자리를 추가해서 계산했기 때문에 첫째자리 나오면 계산 패
			x = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0'); // 끝에서 두자리 숫자로 변환 
			if(x>=10 && x<= 26) {
				dp[i] += dp[i-2];
				dp[i] %=mod;
			}
		}
		System.out.println(dp[n]);
	}
	
}
