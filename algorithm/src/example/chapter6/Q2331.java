package example.chapter6;

import java.util.Scanner;

public class Q2331 {
	/*
	 * check 배열은 0과 0이 아닌 값 n을 가진다. 
	 * 값이 0이면 방문하지 않은 값이고, n은 n번 방문했다는 의미이다.
	 * cnt는 순서, 몇번째 나오는 수 인지 알아야한다. if조건에서 0이 아니라는건 한번 방문 했다는 것이니 그 방문 두번째 한 숫자 전까지가 반복되지 않는 숫자들의 수가 된다.
	 * a가 cnt번째라면 b는 cnt+1번째 수
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
		//수 계산
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
