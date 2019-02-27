package example.chapter2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q10845 {
	
	static Queue<Integer> q = new LinkedList();
	static int front = 0;
	static int back = 0;

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
			} else if(input[0].equals("front")) {
				System.out.println(front());
			} else if(input[0].equals("back")) {
				System.out.println(back());
			}
			n--;
		}
	}
	
	private static void push(int X) {
		q.add(X);
		back = X;
	}
	
	private static int pop() {
		if(empty() == 0) {
			return q.poll();
		} else {
			return -1;
		}
	}
	
	private static int size() {
		return q.size();
	}
	
	private static int empty() {
		if(q.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static int front() {
		if(empty() == 0) {
			return q.peek();
		} else {
			return -1;
		}
	}
	
	private static int back() {
		if(empty() == 0) {
			return back;
		} else {
			return -1;
		}
	}

}
