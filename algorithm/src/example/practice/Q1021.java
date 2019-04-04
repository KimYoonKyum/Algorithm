package example.practice;

import java.util.*;
public class Q1021 {
	
	/*
	 * ���̵���  
	 * ���� ť���� �������� ���� �ε����� ���� ť�� �߰� �ε��� ���� ũ�� 3�� ������ �ڿ������� �ڱ� �ڽű��� �����ϰ�,
	 * �߰� �ε��� ���� �۴ٸ� ���� �ε��� �ٷ� ������ 2�� ������ ������ �ָ� �ּҰ��� ���� �� �ִ�. 
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
				int dq_count=-1; // ���� dq �󿡼� ���� 
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
