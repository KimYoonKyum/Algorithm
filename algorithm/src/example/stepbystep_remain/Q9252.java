package example.stepbystep_remain;

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
		 * dp[i][j]의 값이 이전에 어디서 왔는지 비교해서 
		 * 바로 위에서 왔다면 비교할 행의 값을 1 뺴주는데 이유는
		 * 만약 현재 ACAYK 와 CAP를 비교하는데 K와 P 비교시, 이 값이 위에서 왔다면 이미 P가 어디서 왔는지 알 필요 없기에 그걸 빼고 위에서 찾으면 된다.
		 * 왼쪽 옆에서 온것도 마찬가지.
		 * 
		 * 만약 대각선에서 왓다면 끝 문자가 같은 것이니 비교 행과 열을 하나씩 줄여주고
		 * 그 줄여나간 부분부터 다시 역추적을 하는 원리이다.
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
