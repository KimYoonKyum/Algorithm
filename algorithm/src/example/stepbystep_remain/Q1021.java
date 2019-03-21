package example.stepbystep_remain;

import java.util.*;
public class Q1021 {
	
	/*
	 * 아이디어는  
	 * 현재 큐에서 꺼내야할 값의 인덱스가 지금 큐의 중간 인덱스 보다 크면 3번 연산을 뒤에서부터 자기 자신까지 실행하고,
	 * 중간 인덱스 보다 작다면 현재 인덱스 바로 전까지 2번 연산을 실행해 주면 최소값을 구할 수 있다. 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Deque<Integer> dq = new LinkedList<Integer>();
		for(int i=1; i<=n;i++) {
			dq.addLast(i);
		}
		int[] input = new int[m];
		for(int i=0; i<m;i++) {
			input[i] = sc.nextInt();
		}
		
		int cnt=0;
		int idx=0;
		
		while(idx < m) {
			if(input[idx] == dq.peekFirst()) {
				dq.removeFirst();
				idx++;
				n--;
			} else {
				int dq_count=-1; // 현재 dq 상에서 순서 
				Iterator<Integer> it = dq.iterator();
				while(it.hasNext()) {
					dq_count++;
					int i = it.next(); 
					if(i==input[idx]) {
						break;
					}
				}
				if(dq_count <= n/2) {
					for(int i=0; i<dq_count;i++) {
						dq.addLast(dq.removeFirst());
						cnt++;
					}
				} else if(dq_count > n/2){
					for(int i=0; i<dq.size()-dq_count;i++) {
						dq.addFirst(dq.removeLast());
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
