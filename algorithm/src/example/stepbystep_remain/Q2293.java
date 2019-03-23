package example.stepbystep_remain;

import java.util.*;

public class Q2293 {
	/*
	 *  처음 생각했던 dp[i] = dp[i-1]+ a[k] 방법은 1+2와 2+1을 다른 경우로 간주했기 때문에,
	 *  원하는 결과 값을 얻을 수 없었다.( 모든 dp[]를 채우고 중복을 제거하는 작업을 하였다면  답이나왔겠지만, 좋은 코드와 문제의는 아닌거같다)
	 *  
	 *  아이디어는 동전의 종류를 n가지로 순서대로 동전을 추가하면서 값을 채워 나가는 것으로 생각하는 것이다.
	 *  1원의 동전으로 만드는 경우, d[1]~d[k]까지 값을 채워준다.
	 *  그 다음 1원과 2원의 동전으로 만드는 경우, d[1]~d[k]까지 값을 채워준다.
	 *  다음 1,2,5원도 똑같이 실행한다.
	 *  
	 *  예를 들어 dp[4] 경우 즉, 4원을 만드는 경우는 1,2원으로 만드는 경우의 수에 가치가 2인 동전 하나를
	 *  더해서 dp[4]를 만들 수 있다. 
	 *  dp[4](1,2원으로만드는 경우의 수) = dp[4](이전 1원으로만 만들었던 경우의 수) +dp[2]의 경우에 2를 더한 것-> 그럼 결국 dp[2]가 필요하단 뜻.('2+1+1','2+2' 경우에 해당하는 값)
	 *  으로 생각하여 점화식을 세운 뒤 해결해나가면된다.
	 *  dp[0]은 자기자신을 사용하는 경우라 생각하고 1이라 정의했다.
	 *  (이해가 잘 안되서 표로 그려서 생각함.)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0; i<n;i++) {
			a[i] = sc.nextInt();
		}
		dp[0] = 1;
		for(int i=0;i<n; i++) {
			for(int j=1;j<=k;j++) {
				if(j-a[i]>=0) {
					dp[j] += dp[j-a[i]];
				}
			}
			
		}
		System.out.println(dp[k]);
	}

}
