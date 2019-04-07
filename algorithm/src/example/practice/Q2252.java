package example.practice;
import java.util.*;
public class Q2252 {
	static int[] a;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[n+1];
		
		for(int i=1; i<=m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1] = v2;
		}
		
		for(int i=1; i<=n;i++) {
			System.out.println(a[i]);
		}
		for(int i=1; i<=n;i++) {
			if(a[i] != 0) {
				System.out.println("시작점 ="+i);
			}
		}
	}
	
	private static int dfs(int start) {
		if(check[start]) {
			return a[start];
		}
		return dfs(a[start]);
	}

}
