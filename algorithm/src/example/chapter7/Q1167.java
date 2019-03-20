package example.chapter7;

import java.util.*;

class Edge{
	int to;
	int cost;
	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
public class Q1167 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Edge>[] a = (List<Edge>[]) new List[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = new ArrayList<Edge>();
		}
		
		for(int i=1;i<=n;i++) {
			int x = sc.nextInt();
			while(true) {
				int to = sc.nextInt();
				if(to == -1) break;
				int cost = sc.nextInt();
				a[x].add(new Edge(to,cost));
			}
		}
		//bfs 탐색으로 루트부터 모든정점에 대한 거리 구
		int[] dist = bfs(n,a,1);
		//탐색으로부터 얻어낸 거리 배열에서 가장 경로가 긴 놈찾기 
		int start = 1;
		for(int i=2; i<=n;i++) {
			if(dist[i] > dist[start]) {
				start = i;
			}
		}
		
		// 루트에서부터 거리가가장 먼 정점을 시작으로 모든 정점의 거리 구함
		dist = bfs(n,a,start);
		int ans = dist[1];
		for(int i=2;i<=n;i++) {
			if(ans < dist[i]) {
				ans = dist[i];
			}
		}
		System.out.println(ans);
	}
	
	private static int[] bfs(int n, List<Edge>[] a,int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] check = new boolean[n+1];
		int[] dist = new int[n+1];
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			for(Edge e : a[x]) {
				int to = e.to;
				int cost = e.cost;
				if(!check[to]) {
					check[to] = true;
					dist[to] = dist[x] + cost;
					q.add(to);
				}
			}
		}
		return dist;
	}

}


