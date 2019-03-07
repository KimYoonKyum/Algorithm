package example.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n][2];
		
		for(int i=0; i<n;i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			list[i][0] = x;
			list[i][1] = y;
		}
		
		/*
		 * 자바에서는 comparator와 comparable을 이용하여 객체를 정렬할 수 있다.
		 * comparable 인터페이스는 자바에서 기본적으로 정렬의 기준이 되는 메소드를 정의해 놓은 것. -> 기본적인  것은 오름차순, 내림차순 || 오버라이드해서 사용 가능.
		 * comparator 인터페이스는 기본 정렬과 다르게 정렬할때 사용. -> 일반 적이지 않은, 문자열 길이 순을 정렬이라던지 등등
		 * comparator 생성하고, 오버라이드 어노테이션이 찍혀잇는거 보면 알 수 있음.
		 * 
		 * comparable 인터페이스를 implement해서 새로운 정렬 기준도 만들 수 있다. 
		 * 이때, 구현해야 하는 메소드는 compareTo() 이다.
		 * compareTo 메소드의 리턴값은 이 멤버 변수의 값이 메소드의 파라미터로 들어온 값보다 크면 양수 같으면0 작으면 음수를 리턴한다.
		 * 
		 * comparator 인터페이스도 마찬가지로 구현.
		 */
		Arrays.sort(list, new Comparator<int[]>(){
			public int compare(int a[], int b[]) {
				if(a[0] == b[0]) {
					return Integer.compare(a[1], b[1]);
				}else {
					return Integer.compare(a[0], b[0]);
				}
			}
		});
		
		for(int i=0;i<n;i++) {
			System.out.println(list[i][0]+" "+list[i][1]);
		}
	}
}
