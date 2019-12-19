package recursion;

public class RecursionGugudan {
	public void RecursionGugudanTest(int n, int i) {
		if(i > 9) {
			return;
		}
		System.out.println(n + " * " + i + " = " + n*i);
		RecursionGugudanTest(n, i+1);
	}
	public static void main(String[] args) {
		RecursionGugudan test = new RecursionGugudan();
		test.RecursionGugudanTest(9, 1);
	}
}
