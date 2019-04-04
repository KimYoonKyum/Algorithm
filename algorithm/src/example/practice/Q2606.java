package example.practice;
import java.util.*;
public class Q2606 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		check = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		/*
		for(int i=1; i<=n;i++) {
			if(!check[i]){
				System.out.println(i+"번째노드부터탐색시작합니다.");
				dfs(i);
			}
		}*/
		dfs(1);
		
		System.out.println(count);
	}
	
	private static void dfs(int start) {
		check[start] = true;
		for(int i=0; i < a[start].size();i++) {
			if(!check[a[start].get(i)]) {
				count++;
				dfs(a[start].get(i));
			}
		}
	}

}
