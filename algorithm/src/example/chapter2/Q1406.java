package example.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		int n = Integer.parseInt(br.readLine());
		Stack<String> left = new Stack<String>();
		Stack<String> right = new Stack<String>();
		
		//초기 입력 문자열 스택에 넣기 
		for(int i=0; i<input.length;i++) {
			left.push(input[i]);
		}
		
		for(int x=0; x<n;x++){
			String[] op = br.readLine().split(" ");
			
			
			//명령어 별 분기 
			if(op[0].equals("L")) {
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if(op[0].equals("D")) {
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
			} else if(op[0].equals("B")) {
				if(!left.isEmpty()) {
					left.pop();
				}
			} else if(op[0].equals("P")) {
				left.push(op[1]);
			}
		}
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		//문자열을 + 연산자로 조합하니 메모리 초과가 났음. StringBulider로 조합하니 정상출력 
		StringBuilder sb = new StringBuilder();
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	}
}
