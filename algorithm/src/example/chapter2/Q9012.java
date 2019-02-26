package example.chapter2;

import java.util.Scanner;

public class Q9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T>0) {
			String input = sc.next();
			System.out.println(valid(input));
			T--;
		}
		
	}
	
	private static String valid(String input) {
		int count = 0;
		for(int i=0; i<input.length();i++) {
			if(input.substring(i, i+1).equals("(")) {
				count++;
			} else {
				count--;
			}
			
			// ')' 개수가 더 많으면 올바른 괄호가 아님 
			if(count < 0) {
				return "NO";
			}
		}
		//비어잇으면 올바른 
		if(count == 0) {
			return "YES";
		} else {
			// '(' 개수가 더많아 올바른 아님 
			return "NO";
		}
		
	}
}
