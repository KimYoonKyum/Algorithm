package example.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		boolean[] isDelete = new boolean[n+1];
		isDelete[0] = isDelete[1] = true;
		for(int i=2; i<=n; i++) {
			if(!isDelete[i]) {
				for(int j=i*2; j<=n; j+=i) {
					isDelete[j] = true;
				}
			}
		}
		
		for(int i=m;i<=n;i++) {
			if(isDelete[i] == false) {
				System.out.println(i);
			}
		}
	}
}
