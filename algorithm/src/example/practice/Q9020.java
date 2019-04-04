package example.practice;

import java.util.Scanner;

public class Q9020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			prime(x);
		}
	}
	
	private static void prime(int n) {
		int[] p = new int[n+1];
		int pn = 0;
		boolean[] c = new boolean[n+1];
		for(int i=2; i<=n;i++) {
			if(!c[i]) {
				
				p[pn++] = i;
				for(int j=i*i;j<=n;j+=i) {
					c[j]= true;
				}
			}
		}
		int diff = 10000;
		int x = 0;
		int y = 0;
		for(int i=0; i<=pn;i++) {
			for(int j=i;j<=pn;j++) {
				if(p[i]+p[j] == n) {
					if(p[j]-p[i] < diff) {
						diff=p[j]-p[i];
						x = p[i];
						y = p[j];
					}
				}
			}
		}
		System.out.println(x+" "+y);
	}

}
