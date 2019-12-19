package recursion;

//factorial 재귀, for문 둘다 해보기
public class RecursionFactorialTest {
	//0,1,2,3,6
	public int factorialNonRecursive(int n) {
		int result = 1;
		if(n <= 0) {
			return 0;			
		}
		if(n == 1) {
			return 1;
		}
		for(int i = 1; i <= n; i ++) {
			result *= i;
		}
		
		return result;
		
	}
	
	
	public int factorialRecursive(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorialRecursive(n-1);
	}
	
	
	public static void main(String[] args) {
		RecursionFactorialTest test = new RecursionFactorialTest();
		int result1 = test.factorialNonRecursive(10);
		int result2 = test.factorialRecursive(10);
		
		System.out.println(result1 + " " + result2);
	}
}
