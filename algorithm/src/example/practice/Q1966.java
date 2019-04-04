package example.practice;

import java.util.*;

public class Q1966 {

	/*
	 * ���̵��� ť���� �������� ���� �迭�� �ѹ� Ž���ؼ� ���� �迭 ������ �ִ밪�� �� �ε���i�� �˾Ƴ���
	 * i-1��°���� ť�� �迭�� ����Ǿ� �ִ� �ֵ��� ���� �ڷ� ����������
	 * �ִ밪�� ������ �� �� ���� ���� �ݺ��� ��.
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Pair[] p = new Pair[n];
			Queue<Pair> q = new LinkedList<Pair>();
			for(int i=0; i<n;i++) {
				int w= sc.nextInt();
				Pair e = new Pair(i,w);
				p[i] = e;
				q.add(e);
			}
			int cnt=0;
			while(!q.isEmpty()) {
				int max = p[0].w;
				int maxIndex= 0;
				for(int i=1; i<n;i++) {
					if(max < p[i].w) {
						max = p[i].w;
						maxIndex = i;
					}
				}
				
				for(int i=0; i<maxIndex;i++) {
					Pair e = q.peek();
					q.remove();
					q.add(e);
				}
				
				Pair out = q.remove();
				cnt++;
				n--;
				if(out.index == m) {
					System.out.println(cnt);
				}
				
				int idx=0;
				Iterator it = q.iterator();
				while(it.hasNext()) {
					p[idx++] = (Pair) it.next();
				}
				
			}
			
		}
	}
}
class Pair{
	int index;
	int w;
	Pair(int index, int w){
		this.index = index;
		this.w = w;
	}
}