package example.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input= br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[] num = new int[n];
		StringTokenizer input2= new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			num[i] = Integer.parseInt(input2.nextToken());
		}
		Arrays.sort(num);
		System.out.println(num[k-1]);
	}

}
