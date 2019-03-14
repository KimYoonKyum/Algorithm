package example.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q11724 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		
		for(int i=1; i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1].add(v2);
			a[v2].add(v1);
		}
		
		for(int i=1; i<=n;i++) {
			Collections.sort(a[i]);
		}
		
		check = new boolean[n+1];
		
		//반복문을 정점개수 만큼 수행하면서 방문하지 않았다면 탐색 시작. 1부터 시작하기 때문에 연결요소가 1개라면 결국 모든 정점을 탐색하고 되고, 그게 아니라면 다른 정점으로 가서 탐색 수행.
		int components = 0;
		for(int i=1;i<=n;i++) {
			if(check[i] == false) {
				dfs(i);
				components++;
			}
		}
		
		System.out.println(components);
	}
	
	private static void dfs(int start) {
		if(check[start]) {
			return;
		}
		check[start] = true;
		for(int i=0; i<a[start].size(); i++) {
			if(!check[a[start].get(i)]) {
				dfs(a[start].get(i));
			}
		}
	}
}
