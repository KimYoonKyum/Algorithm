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
		 * �ڹٿ����� comparator�� comparable�� �̿��Ͽ� ��ü�� ������ �� �ִ�.
		 * comparable �������̽��� �ڹٿ��� �⺻������ ������ ������ �Ǵ� �޼ҵ带 ������ ���� ��. -> �⺻����  ���� ��������, �������� || �������̵��ؼ� ��� ����.
		 * comparator �������̽��� �⺻ ���İ� �ٸ��� �����Ҷ� ���. -> �Ϲ� ������ ����, ���ڿ� ���� ���� �����̶���� ���
		 * comparator �����ϰ�, �������̵� ������̼��� �����մ°� ���� �� �� ����.
		 * 
		 * comparable �������̽��� implement�ؼ� ���ο� ���� ���ص� ���� �� �ִ�. 
		 * �̶�, �����ؾ� �ϴ� �޼ҵ�� compareTo() �̴�.
		 * compareTo �޼ҵ��� ���ϰ��� �� ��� ������ ���� �޼ҵ��� �Ķ���ͷ� ���� ������ ũ�� ��� ������0 ������ ������ �����Ѵ�.
		 * 
		 * comparator �������̽��� ���������� ����.
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
