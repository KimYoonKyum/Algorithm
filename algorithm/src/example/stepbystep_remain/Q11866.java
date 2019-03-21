package example.stepbystep_remain;

import java.util.*;
public class Q11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n;i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i=0; i<m-1;i++) {
				q.add(q.peek());
				q.remove();
			}
			sb.append(q.remove()+", ");
		}
		sb.append(">");
		System.out.println(sb.substring(0,sb.length()-3)+">");
	}

}
