package example.chapter1;

import java.util.Scanner;

public class Q10991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N;i++) {
			String center = "";
			String side = "";
			for(int a=1; a<=N-i;a++) {
				side += " ";
			}
			for(int j=1; j<=2*i-1;j++) {
				if(j%2 == 0) {
					center += " ";
				} else {
					center += "*";
				}
			}
			
			System.out.println(side+center);
		}
	}
}
