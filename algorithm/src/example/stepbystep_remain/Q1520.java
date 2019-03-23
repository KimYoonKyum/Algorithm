package example.stepbystep_remain;
import java.util.*;
public class Q1520 {
	/*
	 * dfs탐색 사용하여 맨마지막 도착시에 카운트 해줬는데, 탐색하는 노드 수가 10000*10000이 되버리면
	 * 시간초과에 걸리게된다. ->잘못된 방법이다.
	 * 
	 * 아이디어는 이전에 방문했던 정점은 dp[]에 담아두고 불러오기만 하고 계산만 다시해줘서 
	 * 탐색하는 시간을 줄이게 된다.
	 */
	static int y,x,cnt=0;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static int[][] a,dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		y = sc.nextInt();
		x = sc.nextInt();
		
		a = new int[y][x];
		dp = new int[y][x];
		for(int i=0;i<y;i++) {
			for(int j=0; j<x;j++) {
				a[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
		
	}
	private static int dfs(int n,int m) {
		
		if(n==y-1 && m==x-1) { //도착지점에 왔다면 1을 리턴, 경로가 1개 추가되었기 때문에.
			return 1;
		}
		if(dp[n][m]==-1) { //방문하지 않은 정점이라면,
			dp[n][m] = 0;
			for(int i=0;i<4;i++) {
				int nx = m+dx[i];
				int ny = n+dy[i];
				if(0 <= nx && 0 <= ny && nx < x && ny < y) {
					if(a[ny][nx] < a[n][m]) {// 다음 탐색할 정점이 현재 정점의 값보다 작다면 탐색.
						dp[n][m] += dfs(ny,nx); 
						/*
						 * a[0][0]부터 a[n][m](현재 정점)까지 오는 경우(dp[n][m])에
						 * ny,nx 좌표에서 갈 수 있는 경우의 값을 더해주면된다.
						 * 
						 */
					}
				}
			}
		}
		//방문한 정점이라면 이전에 있던 값을 리턴해준다.
		return dp[n][m];
		
	}
}
