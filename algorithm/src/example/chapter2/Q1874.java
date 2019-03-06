package example.chapter2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q1874 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		int[] out = new int[n+1];
		
		for(int i=1; i<=n;i++) {
			out[i] = sc.nextInt();
		}
		
		int out_index = 1;
		String result = "";
		ArrayList<String> mark = new ArrayList<String>();
		
		for(int i=1; i<=n; i++) {
			st.push(i);
			mark.add("+");
			while(!st.isEmpty() && (st.peek() == out[out_index])) {
				st.pop();
				mark.add("-");
				out_index++;
			}
		}
		
		if(!st.isEmpty()) {
			System.out.println("NO");
		} else {
			for(int i=0; i<mark.size();i++) {
				System.out.println(mark.get(i));
			}
		}
	}
}
