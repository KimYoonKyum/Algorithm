package example.practice;

import java.io.*;
import java.util.Stack;

public class Q9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String input2 = br.readLine();
		
		int length = input.length();
		int length2 = input2.length();
		int[][] dp = new int[length2+1][length+1];
		
		for(int i=1; i<=length2; i++) {
			char c1 = input2.charAt(i-1);
			for(int j=1; j<=length; j++) {
				char c2 = input.charAt(j-1);
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1] +1;
				} else {
					if(dp[i-1][j] < dp[i][j-1]) {
						dp[i][j] = dp[i][j-1];
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		/*
		 * dp[i][j]�� ���� ������ ��� �Դ��� ���ؼ� 
		 * �ٷ� ������ �Դٸ� ���� ���� ���� 1 ���ִµ� ������
		 * ���� ���� ACAYK �� CAP�� ���ϴµ� K�� P �񱳽�, �� ���� ������ �Դٸ� �̹� P�� ��� �Դ��� �� �ʿ� ���⿡ �װ� ���� ������ ã���� �ȴ�.
		 * ���� ������ �°͵� ��������.
		 * 
		 * ���� �밢������ �Ӵٸ� �� ���ڰ� ���� ���̴� �� ��� ���� �ϳ��� �ٿ��ְ�
		 * �� �ٿ����� �κк��� �ٽ� �������� �ϴ� �����̴�.
		 */
		Stack<Character> st = new Stack<Character>();
		int i = length2;
		int j = length;
		while(i>0 && j>0) {
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}else if(dp[i][j] == dp[i][j-1]) {
				j--;
			} else {
				st.push(input2.charAt(i-1));
				i--;
				j--;
			}
		}
		
		System.out.println(dp[length2][length]);
		while(!st.isEmpty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}

}
