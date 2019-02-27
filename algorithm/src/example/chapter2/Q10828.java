package example.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10828 {
	static List<Integer> stack = new ArrayList<Integer>();
	static int topIndex = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
	
		while(n>=0) {
			String[] input = sc.nextLine().split(" ");
			if(input[0].equals("push")) {
				push(Integer.parseInt(input[1]));
			} else if(input[0].equals("pop")) {
				System.out.println(pop());
			} else if(input[0].equals("size")) {
				System.out.println(size());
			} else if(input[0].equals("empty")) {
				System.out.println(empty());
			} else if(input[0].equals("top")) {
				System.out.println(top());
			}
			n--;
		}
	}
	
	private static void push(int X) {
		stack.add(X);
		topIndex = stack.size()-1;
	}
	
	private static int pop() {
		if(empty() == 0) {
			int result = stack.get(topIndex);
			stack.remove(topIndex);
			topIndex--;
			return result;
		} else {
			return -1;
		}
	}
	
	private static int size() {
		return stack.size();
	}
	
	private static int top() {
		if(empty() == 0) {
			return stack.get(topIndex);
		} else {
			return -1;
		}
	}
	
	private static int empty() {
		if(topIndex == -1) {
			return 1;
		} else {
			return 0;
		}
	}
}
