package example.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q11724 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		
		for(int i=0; i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			a[v1].add(v2);
			a[v2].add(v1);
		}
		
		for(int i=1; i<=n;i++) {
			Collections.sort(a[i]);
		}
		
		check = new boolean[n+1];
		
		//�ݺ����� �������� ��ŭ �����ϸ鼭 �湮���� �ʾҴٸ� Ž�� ����. 1���� �����ϱ� ������ �����Ұ� 1����� �ᱹ ��� ������ Ž���ϰ� �ǰ�, �װ� �ƴ϶�� �ٸ� �������� ���� Ž�� ����.
		int components = 0;
		for(int i=1;i<=n;i++) {
			if(check[i] == false) {
				dfs(i);
				components++;
			}
		}
		
		System.out.println(components);
	}
	
	private static void dfs(int start) {
		if(check[start]) {
			return;
		}
		check[start] = true;
		for(int i=0; i<a[start].size(); i++) {
			if(!check[a[start].get(i)]) {
				dfs(a[start].get(i));
			}
		}
	}
}
