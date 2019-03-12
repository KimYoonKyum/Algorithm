package example.chapter5;

import java.util.Arrays;
import java.util.Scanner;

public class Q11652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] num = new long[n];
		for(int i=0; i<n;i++) {
			num[i] = sc.nextLong();
		}
		
		int cnt = 1;
		int pre_cnt = 1;
		
		Arrays.sort(num);
		long ans = num[0];
		
		for(int i=1;i<n;i++) {
			if(num[i-1]==num[i]) {
				cnt++;
			}else {
				cnt = 1;
			}
			if(pre_cnt < cnt) {
				ans = num[i];
				pre_cnt = cnt;
			}
		}
		System.out.println(ans);
	}
}
