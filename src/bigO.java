import java.util.Scanner;

public class bigO {

	public static void main(String [] args) {
        //O(n)
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum += i;
		}
		//O(n)
		sum = (n*(n+1))/2;
		
		//O(n^2)
		for(int i = 0 ; i< n; i++) {
			for(int j = 0; j <= n ; j++) {
				if(i==j)
					sum += j;
			}
		}
	}
	
	/**
	 * 결론 
	 * 시간 복잡도 클 수록 안좋음 (안의 숫자들은 실행한 총 수)
	 * O(1) < O(logN) < O(N) < O(NlogN) < O(N^2) .....
	 * 
	 * */
	
	
}
