package example.stepbystep_remain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n];
		for(int i=0;i<n;i++) {
			s[i] = sc.next();
		}
		
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					int length = o1.length();
					for(int i=0; i<length;i++) {
						if(o1.charAt(i)-'a' > o2.charAt(i)-'a') {
							return 1;
						}else if(o1.charAt(i)-'a' < o2.charAt(i)-'a'){
							return -1;
						} 
					}
					return 0;
				} else {
					return o1.length() - o2.length();
				}
			}
			
		});
		
		for(int i=0;i<n;i++) {
			if(!(i>=1 && s[i].equals(s[i-1]))) {
				System.out.println(s[i]);
			}
		}
	}
	
}
