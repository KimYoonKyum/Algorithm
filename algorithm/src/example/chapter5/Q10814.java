package example.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n][2];
		String[] nameList = new String[n];
		for(int i=0; i<n;i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			String y = input[1];
			
			list[i][0] = x;
			list[i][1] = i;
			nameList[i] = y;
		}
		
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});
		
		for(int i=0; i<n;i++) {
			System.out.println(list[i][0] +" "+ nameList[list[i][1]]);
		}
	}
}
