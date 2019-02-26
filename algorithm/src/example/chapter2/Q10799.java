package example.chapter2;

import java.util.Scanner;
import java.util.Stack;

public class Q10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		int result = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<input.length();i++) {
			//여는 괄호일
			if(input.substring(i,i+1).equals("(")) {
				st.push(i);
			} else {
				// 레이저가아닐때 (파이프의 끝일때) 
				if(i - st.lastElement() > 1) {
					st.pop();
					result += 1;
				} else {//레이저일떄 
					st.pop();
					result += st.size();
				}
			}
		}
		System.out.println(result);
	}
}
