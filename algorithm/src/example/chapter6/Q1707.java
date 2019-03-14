package example.chapter6;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1707 {
	static ArrayList<Integer>[] a;
	static int[] color;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				a[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<m;i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				a[v1].add(v2);
				a[v2].add(v1);
			}
			
			color = new int[n+1];
			
			//연결 요소가 어떻게 되는지 모르니
			for(int i=1; i<=n; i++) {
				if(color[i] == 0) {
					dfs(i,1);
				}
			}
			
			//이분 그래프인지 검산
			boolean isBi = true;
			//정점 개수만큼 반복하면서
			for(int i=1; i<=n; i++) {
				//해당 정점과 연결된 정점의 개수 만큼 반복
				for(int k=0; k<a[i].size();k++) {
					int j = a[i].get(k);
					//인접해 있는 정점이 하나라도 색이 같으면 바로 false가 되고 이분 그래프에 어긋난다.
					if(color[i] == color[j]) {
						isBi = false;
					}
				}
			}
			System.out.println(isBi ? "YES" : "NO");
		}
	}
	/*
	 * 정점이 이분 그래프인지 아닌지 알기 위해 가상의 색을 칠한다 생각하자.
	 * color 배열은 0,1,2의 값을 가진다. 
	 * 0은 아직 방문하지 않은 것.
	 * 1은 방문했는데 빨강.
	 * 2는 방문했는데 파랑.
	 * 이진 그래프가 되려면 1,2 를 번갈아 가면서 칠해야한다.
	 * 그렇게 되면 다음 들어갈 색상은 3-c의 색을 가질 수 있다.
	 */
	//parameter인 c는 다음 칠할 색상이 무엇인지 나타내는 것.
	private static void dfs(int start, int c) {
		color[start] = c;
		for(int i=0; i< a[start].size();i++ ){
			if(color[a[start].get(i)] == 0) {
				dfs(a[start].get(i), 3-c);
			}
		}
	}
}
