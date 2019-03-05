package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		String[] input = br.readLine().split(" ");
		
		for(int i=0; i<input.length;i++) {
			boolean isPrime = true;
			int x = Integer.parseInt(input[i]);
			if(x < 2) {
				isPrime = false;
			}
			for(int j=2; j*j<=x;j++) {
				if(x%j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				count++;
			}
		}
		System.out.println(count);
	}

}
