package example.chapter6;

import java.util.Scanner;

public class Q2331 {
	/*
	 * check �迭�� 0�� 0�� �ƴ� �� n�� ������. 
	 * ���� 0�̸� �湮���� ���� ���̰�, n�� n�� �湮�ߴٴ� �ǹ��̴�.
	 * cnt�� ����, ���° ������ �� ���� �˾ƾ��Ѵ�. if���ǿ��� 0�� �ƴ϶�°� �ѹ� �湮 �ߴٴ� ���̴� �� �湮 �ι�° �� ���� �������� �ݺ����� �ʴ� ���ڵ��� ���� �ȴ�.
	 * a�� cnt��°��� b�� cnt+1��° ��
	 */
	
	static int[] check = new int[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		System.out.println(length(n,p,1));
	}
	
	private static int length(int a, int p, int cnt) {
		if(check[a] != 0) {
			return check[a] - 1;
		}
		check[a] = cnt;
		int b = nextNumber(a,p);
		return length(b,p,cnt+1);
	}
	
	private static int nextNumber(int n, int p) {
		//�� ���
		int result = 0;
		int k = 1000000;
		while(n > 0) {
			if((n/k)>0) {
				int temp = 1;
				for(int l=1; l<=p;l++) {
					temp *= (n/k);
				}
				result += temp;
				n = n - (k*(n/k));
			} else {
				k /= 10;
			}
		}
		return result;
	}
}
