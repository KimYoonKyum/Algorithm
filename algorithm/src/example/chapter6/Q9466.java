package example.chapter6;

import java.util.Scanner;

public class Q9466 {
	static int[] a; // 간선 정보 저장 배열
	static int[] d; // 방문 여부 정보 저장 배열
	static int[] s; // i 정점의 시작이  어떤 놈인지 저장하는 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			a = new int[n+1];
			d = new int[n+1];
			s = new int[n+1];
			for(int i=1; i<=n;i++) {
				a[i] = sc.nextInt();
				d[i] = 0;
				s[i] = 0;
			}
			int ans = 0;
		
			for(int i=1; i<=n; i++) {
				if(d[i] == 0) {
					ans += dfs(i,1,i);
				}
			}
			System.out.println(n-ans);
		}
	}
	/*
	 * 따져야 할 것.
	 * 1. 각각 정점 방문 여부 = d[]배열
	 * 2. 방문할 때마다 몇번째로 방문했느지 = cnt
	 * 3. 방문할 때 가장 첫번째로 시작한 정점이 어떤것인지 = s[]배열과 step
	 */
	private static int dfs(int start, int cnt, int step) {
		if(d[start] != 0) { // start 정점을 방문했으면
			if(step != s[start]) { // 현재 탐색의 시작 정점과 start 정점의 시작점이 다르면 0 리턴
				return 0;
			}
			return cnt - d[start]; 
			/*
			 * 현재 탐색의 시작 정점과 start 정점의 시작점이 같으면 (현재 탐색의 총 방문한 노드 개수 - start 정점을 시작으로 탐색하는 정점의 개수)
			 * 결국, 사이클을 이룬다면 모든 정점이 사이클 그래프의 정점이 되거나
			 * 아니면 탐색한 그래프에서 어느 한 부분만 사이클을 이루게 된다. 그렇게 되면 시작점이 분명히 있을 것이다.
			 * 운좋게 시작점까지 포함하는 모든 정점이 사이클 그래프가 되는 것도 있지만.
			 * 시작 정점에서 얼마만큼 떨어진 정점에서부터 사이클이 시작되는 케이스도 있을 것이다.
			 * 
			 * 그렇다면, cnt- d[start]를 봐보자.
			 * cnt는 현재 탐색에서 총 방문한 정점의 개수 이다. d[start]는 start 정점에서 탐색된 정점의 개수이다. 
			 * 이 연산까지 오기 위해서는 start 정점을 이전에 방문했고, 현재 탐색의 시작 정점과 start 정점의  시작 정점이 같은 경우이다. 
			 * 만약 현재 탐색의 시작 정점과 start 정점의  시작 정점이 다른 경우라면, 이미 다른 그래프에서 방문한 놈이기 때문에 현재 사이클에는 해당 되지 않게 되서 무효처리를 하면된다.
			 * 그래서, 현재 탐색에서 총 방문한 개수에서 사이클이 시작되는 정점부터 탐색된 정점의 숫자를 빼면 사이클이 아닌 정점의 개수를 알게 된다.
			 */
		}
		d[start] = cnt;
		s[start] = step;
		return dfs(a[start],cnt+1, step);
	}
}
