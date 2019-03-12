package example.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input= br.readLine();
		int n = input.length();
		int[] num = new int[n];
		for(int i=0;i<n; i++) {
			num[i] = Integer.parseInt(input.substring(i, i+1));
		}
		
		for(int i=0;i<n; i++) {
			for(int j=i+1;j<n;j++) {
				if(num[j] > num[i]) {
					int temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
			}
		}
		StringBuilder result= new StringBuilder();
		for(int i=0; i<n; i++) {
			result.append(num[i]);
		}
		System.out.println(result);
	}
}
