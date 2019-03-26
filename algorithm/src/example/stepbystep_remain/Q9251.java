package example.stepbystep_remain;
import java.util.*;
import java.io.*;
public class Q9251 {
	/*
	 * LCS 문제
	 * substring은 연속된 부분 문자열이고
	 * subsequence는 연속하지 않는 부분 문자열이다.
	 * (대표적으로 LCS가 사용되는 곳은 염기서열 유사성 분석이란다..)
	 * DP로 접근한다
	 * dp[i][j] 1번쨰 입력된 문자열의 길이 i, 두번째 입력된 문자열의 길이 j
	 * 배열을 만들어서 input1 문자열과 input2의 문자열을 구성하는 문자 하나하나 1:1 비교를 해준다.
	 * 
	 * ACA 와 CA 비교
	 * 여기서 LCS는 'CA'가 된다.
	 * dp[3][2] = 2
	 * dp[3][1] =1
	 * ACA 와 C 를 비교했기 때문에 위와 같은 dp[3][1] =1 이 나올 수 있다.
	 * 여기에 ACA와 CA를 비교해주면 dp[3][2] = 2가 나올 수 있다.
	 * 따라서 문자를 하나 추가해서 비교해주면서 끝자리가 같으면 이전 대각선 왼쪽 위에 있는 값에 +1을 해준다.
	 * 왜냐면 AC와 C를 비교한 값에 A를 추가해서 비교해야지 이미 ACA와 C와 이미 비교된 값에 더하는 것은 의미가 없기 때문.(C가 추가되면 행이 하나 추가된 줄에서 계산해야하기 때문) -> 그림 그리는게 제일 편함.
	 * 
	 * 그 다음, 끝에 자리가 같지 않은 경우는
	 * ACA, CC 
	 * dp[i][j] = dp[i][j-1](AC와 CC 비교한 값) 과 dp[i-1][j](ACA와 C) 값 중 최대값을 선택하면 된다.
	 * 왜냐면 지금 자리는 이미 최장 부분 수열에 속하지 않는 값이기 때문에 이전 값중 최장 부분 수열에 해당하는 큰 값을 선택해와야 한다.
	 * 어차피 최대값을 비교할 두 문자열은 우리가 마지막 비교할 문자열안에 속하니 결국 얘도 최장 부분 수열의 일부분이 되버리니
	 * 둘 중 큰 값을 가져와서 쓰면된다.
	 * 
	 * 이를 끝까지 반복한 것이다 LCS가 된다.
	 * 직접 그림 그려서 보는 것이 편하다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String input2 = br.readLine();
		
		int length = input.length();
		int length2 = input2.length();
		int[][] dp = new int[length2+1][length+1];
		
		
		for(int i=1;i<=length2;i++) {
			char c1 = input2.charAt(i-1);
			for(int j=1; j<=length; j++) {
				char c2 = input.charAt(j-1);
				if(c1 == c2){
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[length2][length]);
	}

}
