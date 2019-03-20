package example.chapter6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2146 {
	static int[][] a;
	static int[][] group;
	static int[][] d;
	static Queue<Land> q = new LinkedList<Land>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n][n];
		group = new int[n][n];
		d = new int[n][n];
		sc.nextLine();
		for(int i=0; i<n;i++) {
			String[] s = sc.nextLine().split(" ");
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		//일단 단지번호 붙이기 처럼 그룹을 나눈다. 
		int cnt = 0;
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1 && group[i][j] == 0) {
					bfs(i,j,++cnt, n);
				}
			}
		}
		
		//토마토 문제처럼 풀기 
		int ans = -1;
		for(int k =1; k<=cnt;k++) { // 그룹만큼 반복하면
			for(int i=0; i<n;i++) {//모든 정점에 대해
				for(int j=0; j<n; j++) {
					d[i][j] = -1;
					//현재 탐색하는 그룹 이외의 애들은 전부 -1
					if(group[i][j] == k) { // 현재 탐색하는 그룹의 값과 현재 정점이 속해있는 그룹의 값이 같으면 
						q.add(new Land(i,j));// 탐색해야 하는 정점이므로 큐에 넣고 값을 0으로 초기화, 0을 넣는 이유는 시작 정점이 0이고 다리 놓을 바다는 1칸마다 길이가 1추가 되기 때문 
						d[i][j] = 0;
					}
				}
			}
			//bfs 탐색 
			while(!q.isEmpty()) { 
				Land p = q.remove();
				int x = p.x;
				int y = p.y;
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(0<=nx && nx <n && 0<= ny && ny <n) {
						if(d[nx][ny] == -1) {// -1 값이 들어가있는 것은, 바다라는 뜻. 이렇게 하면 다음이 -1인 정점까지 도착해서  다음 탐색할 녀석이 바다라면 탐색 
							d[nx][ny] = d[x][y]+1;// 바다의 값들을 정점에서 부터 거리로 채워나가기 
							q.add(new Land(nx,ny));
						}
					}
				}
			}
			
			//모든 정점에 대해
			for(int i=0; i<n; i++) {
				for(int j=0;j<n;j++) {
					/*
					 * 여기 아이디어는 일단 한 그룹은 씩 탐색하여  지금 그룹이외에 애들은 전부 -1로 셋팅해놓고 전체를 탐색한다.
					 * d[i][j]마다 몇 단계에 접근했는지 저장해놓고
					 * d[i][j]이 섬이고(1) 그룹의 값이 현재 탐색하는 그룹의 값고 다르다면 d[i][j]의 값을 구하는데
					 * 그 값이 최소가 되는 값이어야 한다.
					 */
					if(a[i][j]==1 && group[i][j] != k) {// 섬이면서, 그룹번호가 현재 탐색하는 그룹의 번호와 다르다면 -> 다리로연결해야할 놈
						if(ans == -1 || d[i][j]-1 < ans) { // 거리가 최소인 놈 구하기 
							ans = d[i][j]-1;
						}
					}
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	private static void bfs(int x,int y, int cnt, int n) {
		q.add(new Land(x,y));
		group[x][y] = cnt;
		while(!q.isEmpty()) {
			Land p = q.remove();
			x = p.x;
			y = p.y;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx <n && 0<= ny && ny <n) {
					if(a[nx][ny] == 1 && group[nx][ny] == 0) {
						q.add(new Land(nx,ny));
						group[nx][ny] = cnt;
					}
				}
			}
		}
	}

}
class Land{
	int x;
	int y;
	Land(int x, int y){
		this.x = x;
		this.y = y;
	}
}
