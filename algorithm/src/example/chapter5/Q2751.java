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
		
		//Stringbulider를 사용해야함. 이유는 println으로 계속 찍어버리면 println 함수 내부에 다른 함수들이 계속 호출되면서 오버헤드가 발생. 시간이 거의 두배차이.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n;i++){
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
	
	//divide
	private static void mergeSort(int[] arr, int begin,int end) {
		int mid;
		
		//begin 보다 end가 클때만 동작
		if(begin < end) {
			mid = (begin+end)/2;
			mergeSort(arr, begin, mid); // 반씩 쪼개기
			mergeSort(arr, mid+1,end);
			merge(arr,begin,mid,end); // 합치기
		}
	}
	
	//conquer
	private static void merge(int[] arr, int begin, int mid, int end) {
		int x = begin;// 첫번째 배열 시작인덱스
		int y = mid+1; // 두번째배열의 시작 인덱스
		int z = begin; // 결과 배열의 인덱스가 될 놈
		
		while(x<=mid || y<=end) { // 각각 쪼개진 배열의 끝까지만 비교
			
			if(x<=mid && y<=end) { // 두배열 모두 비교할 대상이 남이 있는 상태라면
				if(arr[x] <= arr[y]){ //두배열 비교하면서 첫 번째 배열의 비교할 값이 두번째 배열보다 작으면
					result[z] = arr[x++]; // 결과 배열에 저장하고 첫번째 배열의 다음값을 비교하기 위해 인덱스를 하나 증가 시킴.
				} else {
					result[z] = arr[y++];
				}
			} else if(x<=mid && y>end) { // 두번째 배열의 인덱스가 end 보다 커져 두번째 배열은 비교할 대상이 없는 경우이고, 첫번째는 비교할 값이 남아 있는 경우.
				result[z] = arr[x++];
			} else { //첫 번째 배열은 비교할 값이 없는 경우. 두번째 배열은 남아 있음(x>mid && y<=end 경우) 
				result[z] = arr[y++];
			}
			z++; // 결과 배열의 인덱스 증가
		}
		
		//정렬된 결과  애들을 다음 크기의 배열과 비교하기 위해 다시 이전 배열에 저장 
		// 비교한 값들 만큼만 원래 배열로 옮김. 어차피 비교하는건 end 다음 부터니깐.
		for(int i=begin; i<end+1; i++) { 
			arr[i] = result[i];
		}
	}

}
