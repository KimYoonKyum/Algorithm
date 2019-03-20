package example.chapter7;

import java.util.*;

public class Q11725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		Queue<Integer> q = new LinkedList<Integer>();
		int[] depth = new int[n+1];
		int[] parent = new int[n+1];
		boolean[] check = new boolean[n+1];
		
		//인접리스트로 정보 저
		for(int i=1; i<=n-1;i++) {
			String[] input = sc.nextLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			a[x].add(y);
			a[y].add(x);
		}
		
		check[1] = true;
		q.add(1);
		//탐색 하면서 
		while(!q.isEmpty()){
			int x = q.remove();
			for(int y : a[x]) {
				if(!check[y]) {// 1부터 탐색하니 이미 방문한 애는 방문할 필요없고 현재 방문할 애보다 뎊쓰가 낮
					depth[y] = depth[x]+1;// 현재 뎁쓰는 이전에 탐색해온애의 뎁쓰보다 항상 1이 크다. 간선의 길이가 1
					check[y] = true;// 갓다온 애트루
					parent[y] = x; 
					q.add(y);
				}
			}
			
		}
		
		for(int i=2; i<=n;i++) {
			System.out.println(parent[i]);
		}
	}
}
