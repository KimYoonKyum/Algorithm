package example.stepbystep_remain;

import java.util.Scanner;

public class Q2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;
		int min = -1;
		int cnt = 0;
		
		int[] result = prime(n,m);
		for(int i=0; i<result.length;i++) {
			if(result[i]>=m) {
				if(cnt == 0) {
					min = result[i];
				}
				sum += result[i];
				cnt++;
			}
		}
		
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(min);
		}
		
		
	}

	public static int[] prime(int n,int m) {
		int[] p = new int[n+1];
		int pn = 0;
		boolean[] c = new boolean[n+1];
		
		for(int i=2;i<=n;i++) {
			if(!c[i]) {
				p[pn++] = i;
				for(int j = i*i;j<=n;j+=i) {
					c[j] = true;
				}
			}
		}
		
		return p;
	}
}
