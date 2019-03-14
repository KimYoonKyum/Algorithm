package example.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q1260 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);
		
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		
		for(int i=1; i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m;i++) {
			String[] input2 = br.readLine().split(" ");
			int v1 = Integer.parseInt(input2[0]);
			int v2 = Integer.parseInt(input2[1]);
			a[v1].add(v2);
			a[v2].add(v1);
		}
		
		for(int i=1; i<=n;i++) {
			Collections.sort(a[i]);
		}
		
		check = new boolean[n+1];
		dfs(v);
		System.out.println();
		
		check = new boolean[n+1];
		bfs(v);
		System.out.println();
	}
	
	private static void dfs(int v) {
		if(check[v]) {
			return;
		}
		check[v] = true;
		System.out.print(v+ " ");
		for(int i=0; i<a[v].size();i++) {
			if(check[a[v].get(i)] == false) {
				dfs(a[v].get(i));
			}
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		check[v] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			System.out.print(x + " ");
			for(int i=0; i<a[x].size();i++) {
				if(check[a[x].get(i)] == false) {
					check[a[x].get(i)] = true;
					q.add(a[x].get(i));
				}
			}
		}
	}
}
