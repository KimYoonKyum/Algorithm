package example.chapter5;

import java.util.Scanner;

public class Q2751 {
	static int result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		result = new int[n];
		for(int i=0; i<n;i++){
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr,0,arr.length-1);
		
		//Stringbulider�� ����ؾ���. ������ println���� ��� �������� println �Լ� ���ο� �ٸ� �Լ����� ��� ȣ��Ǹ鼭 ������尡 �߻�. �ð��� ���� �ι�����.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n;i++){
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
	
	//divide
	private static void mergeSort(int[] arr, int begin,int end) {
		int mid;
		
		//begin ���� end�� Ŭ���� ����
		if(begin < end) {
			mid = (begin+end)/2;
			mergeSort(arr, begin, mid); // �ݾ� �ɰ���
			mergeSort(arr, mid+1,end);
			merge(arr,begin,mid,end); // ��ġ��
		}
	}
	
	//conquer
	private static void merge(int[] arr, int begin, int mid, int end) {
		int x = begin;// ù��° �迭 �����ε���
		int y = mid+1; // �ι�°�迭�� ���� �ε���
		int z = begin; // ��� �迭�� �ε����� �� ��
		
		
		while(x<=mid || y<=end) { // ���� �ɰ��� �迭�� �������� ��
			
			if(x<=mid && y<=end) { // �ι迭 ��� ���� ����� ���� �ִ� ���¶��
				if(arr[x] <= arr[y]){ //�ι迭 ���ϸ鼭 ù ��° �迭�� ���� ���� �ι�° �迭���� ������
					result[z] = arr[x++]; // ��� �迭�� �����ϰ� ù��° �迭�� �������� ���ϱ� ���� �ε����� �ϳ� ���� ��Ŵ.
				} else {
					result[z] = arr[y++];
				}
			} else if(x<=mid && y>end) { // �ι�° �迭�� �ε����� end ���� Ŀ�� �ι�° �迭�� ���� ����� ���� ����̰�, ù��°�� ���� ���� ���� �ִ� ���.
				result[z] = arr[x++];
			} else { //ù ��° �迭�� ���� ���� ���� ���. �ι�° �迭�� ���� ����(x>mid && y<=end ���) 
				result[z] = arr[y++];
			}
			z++; // ��� �迭�� �ε��� ����
		}
		
		//���ĵ� ���  �ֵ��� ���� ũ���� �迭�� ���ϱ� ���� �ٽ� ���� �迭�� ���� 
		// ���� ���� ��ŭ�� ���� �迭�� �ű�. ������ ���ϴ°� end ���� ���ʹϱ�.
		for(int i=begin; i<end+1; i++) { 
			arr[i] = result[i];
		}
	}

}
