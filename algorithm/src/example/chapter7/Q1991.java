package example.chapter7;

import java.util.*;
public class Q1991 {

	static int[][] a = new int[26][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		sc.nextLine();
		for(int i=0; i<n;i++) {
			String[] input = sc.nextLine().split(" ");
			int x = input[0].charAt(0)-'A';
			
			if(input[1].equals(".")) {
				a[x][0] = -1;
			} else {
				a[x][0] = input[1].toCharArray()[0]-'A';
			}
			
			if(input[2].equals(".")) {
				a[x][1] = -1;
			} else {
				a[x][1] = input[2].toCharArray()[0]-'A';
			}
		}
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}
	
	private static void preOrder(int x) {
		if(x == -1)return;
		System.out.print((char)(x+'A'));
		preOrder(a[x][0]);
		preOrder(a[x][1]);
	}
	
	private static void inOrder(int x) {
		if(x == -1)return;
		inOrder(a[x][0]);
		System.out.print((char)(x+'A'));
		inOrder(a[x][1]);
	}
	
	private static void postOrder(int x) {
		if(x == -1)return;
		postOrder(a[x][0]);
		postOrder(a[x][1]);
		System.out.print((char)(x+'A'));
	}
}
