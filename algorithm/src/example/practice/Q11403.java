package example.practice;
import java.util.*;
public class Q11403 {
	/*
	 * 아이디어는
	 * 1. 각 7개의 정점인 경우 1부터 시작해서 7까지 dfs 탐색을 한다.
	 * 2. 탐색을 하면서 탐색했던 정점들을 true로 표시해준다.
	 * 3. 그 다음 탐색을 시작했던 정점을 기준으로 1~7까지 반복하면서 탐색을 했던 정점을 1로 표시해준다.
	 * ( 1부터 dfs 탐색을 했다면 지나갔던 정점들은 check[] 배열에서 true로 체크되었기에 1에서 부터 갈수 있는지 없는지 알 수 있다.
	 * 4. 이 반복을 1번 에서 처럼 노드 개수만큼 해준다. 그런데 주의할 점은 각 시작점에서 탐색이 끝난뒤에는 배열을 false로 초기화 해줘야한다.
	 */
	static int n;
	static int[][] a;
	static int[][] path;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1][n+1];
		path = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=n; j++ ) {
				int e = sc.nextInt();
				if(e != 0) {
					a[i][j] = 1;
				}
			}
		}
		
		
		for(int i=1; i<=n;i++) {
			dfs(i);
			for(int j=1; j<=n;j++) {
				if(check[j]) {
					path[i][j] = 1;
				}
			}
			Arrays.fill(check,false);
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=n;j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	private static void dfs(int start) {
		
		for(int i=1; i<=n;i++) {
			if(!check[i] && a[start][i]==1) {
				check[i] = true;
				dfs(i);
			}
		}
	}

}
