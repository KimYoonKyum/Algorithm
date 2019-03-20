package example.chapter6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
	static int[][] a;
	static int[][] dist;
	static Queue<Tomato> q = new LinkedList<Tomato>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		a = new int[n][m];
		dist = new int[n][m];
		sc.nextLine();
		
		for(int i=0; i<n;i++) {
			String[] s = sc.nextLine().split(" ");
			for(int j=0; j<m;j++) {
				a[i][j] = Integer.parseInt(s[j]);
				dist[i][j] = -1;
				if(a[i][j] == 1) { //익은 토마토라
					q.add(new Tomato(i,j));// 탐색 큐에 추가하
					dist[i][j] = 0;//시작일로 초기화 0일부터, 이유는 하루 지나면 옆에 토마토가 익어서 초기값은 0
				}
			}
		}
		while(!q.isEmpty()) {
			Tomato p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(a[nx][ny] == 0 && dist[nx][ny] == -1) {//인접한 장소가 토마토가 있는 장소고 아직 토마토가 익지 않았다
						q.add(new Tomato(nx,ny));// 큐에 넣고 
						dist[nx][ny] = dist[x][y]+1;// 해당 토마토가 익은 날짜를 저장. 저장할때 이전 탐색한 토마토 에서 하루 지나야현재 토마토가 익기때문에 +1
					}
				}
			}
		}
		
		int ans = 0;
		//모든 토마토가 익은 날 알기 위해 길이가 최대인 dist 검색 
		for(int i=0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(ans<dist[i][j]) {
					ans = dist[i][j];
				}
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(dist[i][j] == -1 && a[i][j] == 0) {// 하지만 모든정점이 탐색 되엇을때,dist가 -1 놈이 있으면 익지 않은 토마토가 있다는 것. -> 모든 정점을 탐색하지 못했다. '-1'인놈 떄문
					ans = -1;
				}
			}
		}
		
		System.out.println(ans);
	}
}

class Tomato{
	int x;
	int y;
	Tomato(int x, int y){
		this.x = x;
		this.y = y;
	}
}
