package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long x = Long.parseLong(input[0]);
		long y = Long.parseLong(input[1]);
		
		long two = count(x,2);
		two -= count(x-y,2);
		two -= count(y,2);
		
		long five = count(x,5);
		five -= count(x-y,5);
		five -= count(y,5);
		
		System.out.println(Math.min(two, five));
	}
	
	private static long count(long n, long r) {
		long result = 0;
		for(long i=r; i<=n; i*=r) {
			result += n/i;
		}
		return result;
	}

}
