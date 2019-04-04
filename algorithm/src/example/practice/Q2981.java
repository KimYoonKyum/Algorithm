package example.practice;
import java.util.*;
public class Q2981 {
	/*
	 * 아이디어는 
	 * 우선, 나머지와 몫을 가지고 식을 구해봐야한다.
	 * a[i]번째 수를 m이라는 값으로 나누면 a[i] = r[i]*m + j
	 * 이렇게 표현할 수 있다. 그런데 여기서 m이라는 값으로 나눴을 때 j가 모두 같아야하니
	 * a[i] - a[i-1] = m*(r[i]-r[i-1])으로 나타낼 수 있다.
	 * 그러면 다른 식에도 결국 공통적으로 m이 들어간다는 것을 알 수 있다. 그리고 공통된 m 값을 가지고 있다면, 서로소가 아니라는 것.
	 * 결국 공약수가 존재한다는 것이다. 
	 * 예제에서는 4와 28을 구할 수 있다. 보면 m이 4가 되는 것을 알 수 있다. 공통적으로 들어가는 수이니.
	 * 
	 * 답은 이 수들 중에서 최대공약수를 구하고 그 수의 1을 제외한 약수들이 답이 된다.
	 * 그 이유는 보면 1*4, 4*7 로 4와 28을 표현하는데 m이 2가 되도 표현할 수 있기 때문.
	 * 직접해보는 것이 확인하기가 쉬운듯..
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] r = new int[n];
		
		for(int i=0; i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		for(int i=1; i<n;i++) {
			r[i] = a[i]-a[i-1];
		}

		int gcd = r[0];
		for(int i=1; i<n;i++) {
			gcd = gcd(gcd, r[i]);
		}
		
		for(int i=2; i<=gcd;i++) {
			if(gcd%i == 0) {
				System.out.println(i);
			}
		}
		
	}
	
	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}

}
