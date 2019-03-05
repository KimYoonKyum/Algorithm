package example.chapter4;

import java.io.IOException;
import java.util.Scanner;

public class Q1373 {

	public static void main(String[] args) throws IOException {
		Scanner sc =  new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		
		// 길이가 3으로 나눠 떨어지지 않는 경우 처리하면서 미리 출
		if(n%3 == 1) {
			System.out.print(s.charAt(0)); //1이 나머지인 경우는 맨 앞자리가 1인 것임. 그래서 1*2^1이니 그냥 출력하면됨.
		} else if(n%3 ==2) {
			System.out.print((s.charAt(0)-'0')*2 +(s.charAt(1)-'0')); // 위와 같이 처리 
		}
		
		for(int i=n%3; i<n; i+=3) {
			System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
		}
		System.out.println();
	}

}
