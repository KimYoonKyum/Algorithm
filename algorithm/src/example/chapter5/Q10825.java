package example.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q10825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i=0; i<n;i++) {
			String[] input = br.readLine().split(" ");
			Student st = new Student();
			st.ko = Integer.parseInt(input[1]); // 국어점수
			st.en = Integer.parseInt(input[2]); // 영어점수
			st.ma = Integer.parseInt(input[3]); // 수학점수
			st.name = input[0];
			list.add(st);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<n;i++) {
			System.out.println(list.get(i).name);
		}
		
	}

}
