package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		String result = "";
		while(n>0) {
			int remain = n%b;
			if(remain<10) {
				result += (remain+"");
			} else {
				result += (char)((remain-10)+'A');
			}
			n /= b;
		}
		
		String result2 = "";
		for(int i=result.length()-1;i>=0;i--) {
			result2 += result.charAt(i);
		}
		System.out.println(result2);
	}

}
