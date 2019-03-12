package example.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1377 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Info> list = new ArrayList<Info>();
		
		for(int i=0; i<n; i++) {
			Info info = new Info();
			info.num = sc.nextInt();
			info.index = i;
			list.add(info);
		}
		
		Collections.sort(list);
		int result = 0;
		for(int i=0; i<n; i++) {
			if(result < list.get(i).index- i) {
				result = list.get(i).index- i;
			}
		}
		System.out.println(result+1);
	}
}
