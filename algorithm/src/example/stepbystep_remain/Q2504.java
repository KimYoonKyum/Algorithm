package example.stepbystep_remain;

import java.util.*;
public class Q2504 {

	/*
	 * 분배 법칙에서 나온 아이디어.
	 * (()[][]) = (()) + ([][]) 라는 아이디어.
	 * 
	 * '(' 나오면 그걸로 감싸진 애들은 전부 곱하기 2를 해줘야함. 그래서 '(' 나올떄마다 임시 값에 *2 연산 실행.
	 * ')' 나온다는 것은 값을 값을 갱신할 타이밍이라는 것. sum에 값을 더해주고 다시 )가 나온 횟수 만큼 나누기를 해준다. => (가 더 많다는 것은 뒤에 또 곱하기를 해줘야하는 애가 있기때문이라서.
	 * 중괄호도 이와 같이 풀어주면 된다.
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
