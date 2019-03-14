package example.chapter6;

import java.util.Scanner;

public class Q10451 {
	static int[] a;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			a = new int[n+1];
			
			for(int i=1; i<=n;i++) {
				a[i] = sc.nextInt();
			}
			check = new boolean[n+1];
			int count = 0;
			//연결 요소 개수 찾은 것과 똑같이 풀어주면 된다. 대신에 인접행렬이나 리스트 사용할 필요가 없는데, 어차피 각 정점들은 1:1 연결이기 때문이다. 한 정점이 여러 정점과 간선을 이룰 수없다.
			for(int i=1; i<=n;i++) {
				if(!check[i]) {
					dfs(i);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
	private static void dfs(int start) {
		if(check[start]) return;
		check[start] = true;
		dfs(a[start]);
	}
}
