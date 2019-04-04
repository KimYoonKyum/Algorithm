package example.practice;

import java.io.*;
import java.util.*;
public class Q10866 {
	static int front;
	static int back;
	static Deque<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n;i++) {
			String[] input = br.readLine().split(" ");
			String op = input[0];
			
			if(op.equals("push_front")) {
				int x = Integer.parseInt(input[1]);
				push_front(x);
			} else if(op.equals("push_back")) {
				int x = Integer.parseInt(input[1]);
				push_back(x);
			} else if(op.equals("pop_front")) {
				pop_front();
			} else if(op.equals("pop_back")) {
				pop_back();
			} else if(op.equals("size")) {
				size();
			} else if(op.equals("empty")) {
				empty();
			} else if(op.equals("front")) {
				front();
			} else if(op.equals("back")) {
				back();
			}
		}
	}
	
	private static void push_front(int x) {
		if(q.isEmpty()) {
			back=x;
		}
		q.push(x);
		front = x;
	}
	
	private static void push_back(int x) {
		if(q.isEmpty()) {
			front=x;
		}
		q.offer(x);
		back = x;
	}
	
	private static void pop_front() {
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		System.out.println(q.remove());
		if(q.isEmpty()) {
			back= -1;
			front = -1;
			return;
		}
		front = q.peekFirst();
	}
	
	private static void pop_back() {
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		System.out.println(q.removeLast());
		if(q.isEmpty()) {
			front = -1;
			back = -1;
			return;
		}
		back = q.peekLast();
	}
	
	private static void size() {
		System.out.println(q.size());
	}
	
	private static boolean empty() {
		if(q.isEmpty()) {
			System.out.println(1);
			return true;
		}
		System.out.println(0);
		return false;
	}
	
	private static void front() {
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		System.out.println(front);
	}
	
	private static void back() {
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		System.out.println(back);
	}

}
