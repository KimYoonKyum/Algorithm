package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		int gcd = gcd(a,b);
		int lcm = lcm(a,b, gcd);
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	private static int gcd(int a, int b) {
		if(b ==0) {
			return a;
		} else {
			return gcd(b,(a%b));
		}
	}
	
	private static int lcm(int a, int b, int gcd) {
		return(a/gcd)*(b/gcd)*gcd;
	}

}
