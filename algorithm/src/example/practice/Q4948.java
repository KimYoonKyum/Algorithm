package example.practice;

import java.util.Scanner;

public class Q4948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			System.out.println(prime(n));
		}
	}
	private static int prime(int n) {
		int pn = 0;
		int m = 2*n;
		int[] p = new int[m+1];
		boolean[] c = new boolean[m+1];
		
		for(int i=2; i<=m;i++) {
			if(!c[i]) {
				if(i>n) {
					p[pn++] = i;
				}
				for(int j=i*2; j<=m;j+=i) {
					c[j] = true;
				}
			}
		}
		
		return pn;
	}
}
