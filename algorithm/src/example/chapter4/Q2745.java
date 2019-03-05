package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String n = input[0];
		int b = Integer.parseInt(input[1]);
		int result = 0;
		
		for(int i=0; i<n.length();i++) {
			if('0' <= n.charAt(i) && n.charAt(i) <= '9') {
				result = result * b + (n.charAt(i) - '0');
			} else {
				result = result * b + (n.charAt(i) - 'A' + 10);
			}
		}
		System.out.println(result);
	}

}
