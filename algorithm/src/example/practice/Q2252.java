package example.practice;
import java.util.*;
public class Q2252 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	static int[] degree;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		check = new boolean[n+1];
		degree = new int[n+1];
		q = new LinkedList();
		
		a = (ArrayList<Integer>[]) new ArrayList[n+1];
		
		for(int i=1; i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1].add(v2);
			++degree[v2];
		}
		for(int i=1; i<=n;i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			System.out.print(v+" ");
			for(int x : a[v]) {
				degree[x]--;
				if(degree[x] == 0) {
					q.offer(x);
				}
			}
			
		}
	}
	/*
	 * 아이디어는 입력시에 차수를 측정한 다음에 차수가 0인 애들부터 큐에 넣고 
	 * 탐색 실행하면서 차수를 하나씩 줄여주면서 끝까지 가면된다.
	 */
}
