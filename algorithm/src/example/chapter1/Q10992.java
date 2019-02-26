package example.chapter1;

import java.util.Scanner;

public class Q10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N;i++) {
			String center = "";
			String side = "";
			for(int a=1; a<=N-i;a++) {
				side += " ";
			}
			if(i != N) {
				for(int j=1; j<=2*i-1;j++) {
					if(j == 1 || j == 2*i-1) {
						center += "*";
					} else {
						center += " ";
					}
				}
			} else {
				for(int j=1; j<=2*i-1;j++) {
					center += "*";
				}
			}
			
			System.out.println(side+center);
		}
	}
}
