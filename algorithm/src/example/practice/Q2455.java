package example.practice;
import java.util.*;
public class Q2455 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int sum = 0;
		int max = 0;
		for(int i=0; i<8; i++) {
			int tmp = sc.nextInt();
			if(i%2 == 0) {
				sum -= tmp;
			} else {
				sum += tmp;
			}
			
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}

}
