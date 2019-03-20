package example.chapter6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q4963 {
	static int[][] d; // 방문여부 정보 저장 배열
	static int[][] a; // 정점 정보 저장 배열
	
	static final int[] dx = {-1,-1,-1,0,0,1,1,1};
	static final int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        
        while(true) {
        	int w = sc.nextInt();
            int h = sc.nextInt();
            if(w==0 && h==0) {
            	break;
            }
	        d = new int[h][w];
			a = new int[h][w];
	        sc.nextLine();
	        for (int i=0; i<h; i++) {
	            String s = sc.nextLine();
	            for (int j=0; j<w; j++) {
	                a[i][j] = s.charAt(2*j) - '0';
	            }
	        }
	        
			int cnt = 0; // 그룹 번호 카운트
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(a[i][j] == 1 && d[i][j] == 0) { // 정점이 집이고, 방문하지 않았다면 bfs 수행
						bfs(i,j, ++cnt,w,h);
					}
				}
			}
			
			int[] ans = new int[cnt]; // 각 그룹마다 몇개의 집이 있는지 카운트 하기 위한 배열
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(d[i][j] != 0) {
						ans[d[i][j]-1]+=1; // 각 배열의 인덱스는 1번단지부터 n번 단지까지를 의미, 배열 전체 탐색하면서 d배열을 바탕으로 단지가 몇인지 알아내고 그에 해당하는것을 만날때마다 +1
					}
				}
			}
			
			Arrays.sort(ans); // 1단지부터 정렬하기 위해서 array.sort 사용
	        System.out.println(cnt);
	        /*for (int i=0; i<cnt; i++) {
	            System.out.println(ans[i]);
	        }*/
        }
	}
	private static void bfs(int x, int y, int cnt, int w, int h) {
		//bfs는 큐를 바탕으로 탐색
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y)); // 시작정점 저장
		d[x][y] = cnt; // 시작정점이 몇단지 인지 저장
		while(!q.isEmpty()) { // 큐가 empty일떄까지
			Pair p = q.remove(); //  pop
			x = p.x;
			y = p.y;
			for(int i=0; i<8;i++) { // 인접행렬이나 인접리스트가 필요없는 이유는 좌표상으로 위아래좌우만 갈수 있기 때문에 그에 해당하는 4개만 탐색하면됨.
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && 0 <= ny && nx < h && ny < w) {
					if(a[nx][ny] == 1 && d[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						d[nx][ny] = cnt;
					}
				}
			}
		}
	}

}
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

