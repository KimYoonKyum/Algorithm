package basic;

public class Chapter4 {
	/*
	 * 나머지 연산
	 * (a+b)%c = (a%c+b%c)%c
	 * (a*b)%c = (a%c*b%c)%c
	 * 
	 * 최대공약수
	 * 유클리드 호제법 이용하여 구현
	 * int gcd(int a, int b){
	 * 	if(b == 0 ){
	 *  	return a;
	 *  } else {
	 *  	return gcd(b,a%b);
	 *  }
	 * }
	 * 
	 * 최소 공배수 * 최대 공약수 = 입력1 과 입력 2의 곱
	 * 
	 * 
	 * 진법 변환
	 * 11 을 3진법으로
	 * 11/3 ->2
	 * 3/3 -> 0
	 * 1 ->1
	 * 거꾸로 출력 102
	 * 
	 * 
	 * 
	 * 소수인지 아닌지 구함 
	 * bool prime(int n){
	 * 	if(n<2){
	 * 		return false;	
	 * 	}
	 * 	for(int i=2; i*i<=n;i++){
	 * 		if(n % i == 0){
	 * 			return false;
	 * 		}
	 * 	}
	 * 	return true;
	 * }
	 * 
	 * 위 코드는 시간 복잡도 O(root N) 이다.
	 * 저렇게 구현할 수 있는 이유는 N = a*b라 했을때, a의 최대 범위 루트n 을 넘지 않는다.
	 * 만약 넘어버리면 두 수의 곱이 n보다 커지기 때문이다.
	 * 그래서 기준 하나를 루트n까지 잡고 반복문을 실행 하면 된다.
	 */
	
	//시간 복잡도가 더 나아진 소수 구하기 -> 에라토스테네스의 체, 2의배수, 3의배수 ,,, 순서대로 지우기
	public static void prime(int n) {
		int[] p = new int[n+1]; //소수 저장
		int pn = 0; //소수의 개수
		boolean[] c = new boolean[n+1]; // 지워졌으면 true
		
		// 2부터 n까
		for(int i=2; i<=n; i++) {
			if(c[i] == false) { //지워지지 않았으면 
				p[pn++]=i; // 소수 저장하고, 소수 개수 한개 증가.
				for(int j=i*i; j<=n; j+=i) { //제곱수 부터 시작하는 이유는 이 전부터 2의 배수 3의 배수 식으로 지웠기 떄문에. j+=i인 이유는 i의 배수이니 i만큼 증가해야하기 때문. 
					c[j] = true; // 배수 삭제 
				}
			}
		}
	}
}
