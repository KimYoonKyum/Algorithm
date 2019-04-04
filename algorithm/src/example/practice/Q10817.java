package example.practice;

import java.util.Scanner;

public class Q10817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int center = 0;
		if(a > b) {
			if(b>c) {
				center = b;
			} else {
				if(c>a) {
					center = a;
				} else {
					center = c;
				}
			}
		}else {
			if(a>c) {
				center = a;
			} else {
				if(b>c) {
					center = c;
				} else {
					center = b;
				}
			}
		}
		System.out.println(center);
	}

}
