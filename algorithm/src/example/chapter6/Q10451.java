package example.chapter6;

import java.util.Scanner;

public class Q10451 {
	static int[] a;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			a = new int[n+1];
			
			for(int i=1; i<=n;i++) {
				a[i] = sc.nextInt();
			}
			check = new boolean[n+1];
			int count = 0;
			//���� ��� ���� ã�� �Ͱ� �Ȱ��� Ǯ���ָ� �ȴ�. ��ſ� ��������̳� ����Ʈ ����� �ʿ䰡 ���µ�, ������ �� �������� 1:1 �����̱� �����̴�. �� ������ ���� ������ ������ �̷� ������.
			for(int i=1; i<=n;i++) {
				if(!check[i]) {
					dfs(i);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
	private static void dfs(int start) {
		if(check[start]) return;
		check[start] = true;
		dfs(a[start]);
	}
}
