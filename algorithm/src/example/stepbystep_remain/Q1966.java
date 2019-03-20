package example.stepbystep_remain;

import java.util.*;

public class Q1966 {

	/*
	 * 아이디어는 큐에서 내보내기 전에 배열을 한번 탐색해서 지금 배열 상태의 최대값과 그 인덱스i를 알아내서
	 * i-1번째까지 큐와 배열에 저장되어 있는 애들을 가장 뒤로 보내버리고
	 * 최대값을 내보낸 뒤 또 위와 같은 반복을 함.
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