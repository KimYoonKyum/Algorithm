package example.chapter6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {
	static int[][] a;
	static boolean[][] check;
	static int[][] dist;
	static Queue<Coordinate> q = new LinkedList<Coordinate>();
	static final int[] dx = {0,-1,0,1};
	static final int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		a = new int[n][m];
		check = new boolean[n][m];
		dist = new int[n][m];
		sc.nextLine();
		for(int i=0; i<n;i++) {
			String s = sc.nextLine();
			for(int j=0; j<m;j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		q.add(new Coordinate(0,0));
		check[0][0] = true;
		dist[0][0] =1; 
		while(!q.isEmpty()) {
			Coordinate p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(a[nx][ny] == 1 && !check[nx][ny]) {
						q.add(new Coordinate(nx,ny));
						dist[nx][ny] = dist[x][y]+1;
						check[nx][ny] = true;
					}
				}
			}
		}
		System.out.println(dist[n-1][m-1]);
		
	}

}

class Coordinate {
	int x;
	int y;
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}
