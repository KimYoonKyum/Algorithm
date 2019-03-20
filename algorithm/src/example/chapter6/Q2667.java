package example.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2667 {
	static int[][] d; // �湮���� ���� ���� �迭
	static int[][] a; // ���� ���� ���� �迭
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n][n];
		a = new int[n][n];
        sc.nextLine();
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
		
		int cnt = 0; // �׷� ��ȣ ī��Ʈ
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1 && d[i][j] == 0) { // ������ ���̰�, �湮���� �ʾҴٸ� bfs ����
					bfs(i,j, ++cnt,n);
					System.out.println();
				}
			}
		}
		
		int[] ans = new int[cnt]; // �� �׷츶�� ��� ���� �ִ��� ī��Ʈ �ϱ� ���� �迭
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(d[i][j] != 0) {
					ans[d[i][j]-1]+=1;
				}
			}
		}
		
		Arrays.sort(ans);
        System.out.println(cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(ans[i]);
        }
	}
	private static void bfs(int x, int y, int cnt, int n) {
		Queue<Pair2> q = new LinkedList<Pair2>();
		q.add(new Pair2(x,y));
		d[x][y] = cnt;
		while(!q.isEmpty()) {
			Pair2 p = q.remove();
			x = p.x;
			y = p.y;
			for(int i=0; i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && 0 <= ny && nx < n && ny < n) {
					if(a[nx][ny] == 1 && d[nx][ny] == 0) {
						q.add(new Pair2(nx, ny));
						d[nx][ny] = cnt;
					}
				}
			}
		}
	}

}
class Pair2{
	int x;
	int y;
	Pair2(int x, int y){
		this.x = x;
		this.y = y;
	}
}
