package example.practice;

import java.util.*;
public class Q2504 {

	/*
	 * �й� ��Ģ���� ���� ���̵��.
	 * (()[][]) = (()) + ([][]) ��� ���̵��.
	 * 
	 * '(' ������ �װɷ� ������ �ֵ��� ���� ���ϱ� 2�� �������. �׷��� '(' ���Ë����� �ӽ� ���� *2 ���� ����.
	 * ')' ���´ٴ� ���� ���� ���� ������ Ÿ�̹��̶�� ��. sum�� ���� �����ְ� �ٽ� )�� ���� Ƚ�� ��ŭ �����⸦ ���ش�. => (�� �� ���ٴ� ���� �ڿ� �� ���ϱ⸦ ������ϴ� �ְ� �ֱ⶧���̶�.
	 * �߰�ȣ�� �̿� ���� Ǯ���ָ� �ȴ�.
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split("");
		Stack<String> st = new Stack<String>();
		int sum = 0;
		int temp = 1;
		for(int i=0; i<s.length;i++) {
			if(s[i].equals("(")) {
				st.push("(");
				temp *=2;
			}else if(s[i].equals(")") && (st.empty()||!st.peek().equals("("))) {
				System.out.println(0);
				return;
			} else if(s[i].equals("]") && (st.empty()||!st.peek().equals("["))) {
				System.out.println(0);
				return;
			} else if(s[i].equals(")")) {
				if(s[i-1].equals("(")) {
					sum += temp;
				}
				st.pop();
				temp /=2;
			} else if(s[i].equals("[")) {
				st.push("[");
				temp *=3;
			} else if(s[i].equals("]")) {
				if(s[i-1].equals("[")) {
					sum += temp;
				}
				st.pop();
				temp /=3;
			} 
		}
		if(!st.empty()) {
			System.out.println(0);
			return;
		}
		System.out.println(sum);
	}

}
