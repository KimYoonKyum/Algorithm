package example.stepbystep_remain;
import java.util.*;
public class Q4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int i=0; i<c;i++) {
			int n = sc.nextInt();
			int[] s = new int[n];
			int sum = 0;
			int avg = 0;
			int cnt = 0;
			for(int j=0;j<n;j++) {
				s[j] = sc.nextInt();
				sum+=s[j];
			}

			avg = sum/n;
			for(int k=0;k<n;k++) {
				if(avg<s[k]) {
					cnt++;
				}
			}
			float result = ((float)cnt/n)*100;
			System.out.println(String.format("%.3f", result)+"%");
		}
	}

}
