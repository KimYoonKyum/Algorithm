package example.chapter2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Queue q = new LinkedList<Integer>();
		for(int i=1; i<=N;i++) {
			q.offer(i);
		}
		
		String result = "<";
		
		while(!q.isEmpty()) {
			for(int i=0; i < M-1; i++) {
				q.offer(q.poll());
			}
			result = result + q.poll() + ", ";
		}
		result = result.substring(0,result.length()-2);
		
		System.out.println(result+">");
	}
}
