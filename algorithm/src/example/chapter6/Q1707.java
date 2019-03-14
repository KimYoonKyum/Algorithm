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
			
			//���� ��Ұ� ��� �Ǵ��� �𸣴�
			for(int i=1; i<=n; i++) {
				if(color[i] == 0) {
					dfs(i,1);
				}
			}
			
			//�̺� �׷������� �˻�
			boolean isBi = true;
			//���� ������ŭ �ݺ��ϸ鼭
			for(int i=1; i<=n; i++) {
				//�ش� ������ ����� ������ ���� ��ŭ �ݺ�
				for(int k=0; k<a[i].size();k++) {
					int j = a[i].get(k);
					//������ �ִ� ������ �ϳ��� ���� ������ �ٷ� false�� �ǰ� �̺� �׷����� ��߳���.
					if(color[i] == color[j]) {
						isBi = false;
					}
				}
			}
			System.out.println(isBi ? "YES" : "NO");
		}
	}
	/*
	 * ������ �̺� �׷������� �ƴ��� �˱� ���� ������ ���� ĥ�Ѵ� ��������.
	 * color �迭�� 0,1,2�� ���� ������. 
	 * 0�� ���� �湮���� ���� ��.
	 * 1�� �湮�ߴµ� ����.
	 * 2�� �湮�ߴµ� �Ķ�.
	 * ���� �׷����� �Ƿ��� 1,2 �� ������ ���鼭 ĥ�ؾ��Ѵ�.
	 * �׷��� �Ǹ� ���� �� ������ 3-c�� ���� ���� �� �ִ�.
	 */
	//parameter�� c�� ���� ĥ�� ������ �������� ��Ÿ���� ��.
	private static void dfs(int start, int c) {
		color[start] = c;
		for(int i=0; i< a[start].size();i++ ){
			if(color[a[start].get(i)] == 0) {
				dfs(a[start].get(i), 3-c);
			}
		}
	}
}
