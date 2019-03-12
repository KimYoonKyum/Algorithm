package example.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q2108 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int[][] freq = new int[8001][2];
		for(int i=0; i<n;i++) {
			num[i] = sc.nextInt();
			freq[num[i]+4000][0]=num[i];
			freq[num[i]+4000][1]++;
		}
		
		Arrays.sort(num);
		double answer1 = 0.0;
		int answer2 = num[n/2];
		int answer3 = 0;
		int answer4 = 0;
		for(int i=0; i<n;i++) {
			answer1 += num[i];
		}
		
		if(n>=2) {
			Arrays.sort(freq, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) {
						return Integer.compare(o2[0], o1[0]);
					}else {
						return Integer.compare(o1[1], o2[1]);
					}
				}
			});
			
			ArrayList<Integer> numberlist = new ArrayList<Integer>();
			ArrayList<Integer> freqlist = new ArrayList<Integer>();
			for(int i=0; i<8001;i++) {
				if(freq[i][1] != 0) {
					numberlist.add(freq[i][0]);
					freqlist.add(freq[i][1]);
				}
			}
			if(freqlist.get(freqlist.size()-1).equals(freqlist.get(freqlist.size()-2))) {
				answer3 = numberlist.get(numberlist.size()-2); 
			} else {
				answer3 = numberlist.get(numberlist.size()-1); 
			}
				
		} else {
			answer3 = num[0];
		}
		answer4 = num[n-1]-num[0];
		
		System.out.println(Math.round(answer1/n));
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
	}
	
}
