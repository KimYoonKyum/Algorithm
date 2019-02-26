package example.chapter1;

import java.util.Scanner;

public class Q2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String center = "";
			String side = "";
			for(int j=1; j<=i; j++) {
				side += "*";
			}
			for(int k=1; k<=(T-i)*2; k++) {
				center += " ";
			}
			System.out.println(side+center+side);
		}
		
		for(int i=T-1;i>=1;i--) {
			String center = "";
			String side = "";
			for(int j=1; j<=i; j++) {
				side += "*";
			}
			for(int k=1; k<=(T-i)*2; k++) {
				center += " ";
			}
			System.out.println(side+center+side);
		}
	}
}

