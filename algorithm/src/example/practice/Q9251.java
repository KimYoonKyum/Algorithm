package example.practice;
import java.util.*;
import java.io.*;
public class Q9251 {
	/*
	 * LCS ����
	 * substring�� ���ӵ� �κ� ���ڿ��̰�
	 * subsequence�� �������� �ʴ� �κ� ���ڿ��̴�.
	 * (��ǥ������ LCS�� ���Ǵ� ���� ���⼭�� ���缺 �м��̶���..)
	 * DP�� �����Ѵ�
	 * dp[i][j] 1���� �Էµ� ���ڿ��� ���� i, �ι�° �Էµ� ���ڿ��� ���� j
	 * �迭�� ���� input1 ���ڿ��� input2�� ���ڿ��� �����ϴ� ���� �ϳ��ϳ� 1:1 �񱳸� ���ش�.
	 * 
	 * ACA �� CA ��
	 * ���⼭ LCS�� 'CA'�� �ȴ�.
	 * dp[3][2] = 2
	 * dp[3][1] =1
	 * ACA �� C �� ���߱� ������ ���� ���� dp[3][1] =1 �� ���� �� �ִ�.
	 * ���⿡ ACA�� CA�� �����ָ� dp[3][2] = 2�� ���� �� �ִ�.
	 * ���� ���ڸ� �ϳ� �߰��ؼ� �����ָ鼭 ���ڸ��� ������ ���� �밢�� ���� ���� �ִ� ���� +1�� ���ش�.
	 * �ֳĸ� AC�� C�� ���� ���� A�� �߰��ؼ� ���ؾ��� �̹� ACA�� C�� �̹� �񱳵� ���� ���ϴ� ���� �ǹ̰� ���� ����.(C�� �߰��Ǹ� ���� �ϳ� �߰��� �ٿ��� ����ؾ��ϱ� ����) -> �׸� �׸��°� ���� ����.
	 * 
	 * �� ����, ���� �ڸ��� ���� ���� ����
	 * ACA, CC 
	 * dp[i][j] = dp[i][j-1](AC�� CC ���� ��) �� dp[i-1][j](ACA�� C) �� �� �ִ밪�� �����ϸ� �ȴ�.
	 * �ֳĸ� ���� �ڸ��� �̹� ���� �κ� ������ ������ �ʴ� ���̱� ������ ���� ���� ���� �κ� ������ �ش��ϴ� ū ���� �����ؿ;� �Ѵ�.
	 * ������ �ִ밪�� ���� �� ���ڿ��� �츮�� ������ ���� ���ڿ��ȿ� ���ϴ� �ᱹ �굵 ���� �κ� ������ �Ϻκ��� �ǹ�����
	 * �� �� ū ���� �����ͼ� ����ȴ�.
	 * 
	 * �̸� ������ �ݺ��� ���̴� LCS�� �ȴ�.
	 * ���� �׸� �׷��� ���� ���� ���ϴ�.
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
