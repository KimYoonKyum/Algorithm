package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9613 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- >0) {
			String[] input = br.readLine().split(" ");
			long result = 0;
			int n = Integer.parseInt(input[0]);
			for(int i=1; i<=n;i++) {
				for(int j=i+1; j<=n;j++) {
					result += gcd(Long.parseLong(input[i]),Long.parseLong(input[j]));
				}
			}
			System.out.println(result);
		}
	}
	
	private static long gcd(long a, long b) {
		if(b ==0) {
			return a;
		} else {
			return gcd(b,(a%b));
		}
	}

}
