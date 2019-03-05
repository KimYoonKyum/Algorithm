package example.chapter4;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6588 {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean[] isDelete = new boolean[MAX+1];
		isDelete[0] = isDelete[1] = true;
		ArrayList<Integer> prime = new ArrayList<Integer>();
		for(int i=2; i*i<=MAX; i++) {
			if(isDelete[i]) continue;
			prime.add(i);
			
			for(int j= i*2; j<=MAX; j+=i) {
				isDelete[j] = true;
			}
		}
		
		while(true) {
			int n = sc.nextInt();
			if(n == 0) {
				break;
			}
			boolean flag = false;
			for(int i=0; i<prime.size();i++) {
				int p = prime.get(i);
				if(!isDelete[n-p]) {
					System.out.println(n+" = "+p +" + "+ (n-p));
					flag = true;
					break;
				}
			}
			if(!flag) System.out.println("Goldbach's conjecture is wrong.");
		}
	}
}
