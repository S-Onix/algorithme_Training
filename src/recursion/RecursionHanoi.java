package recursion;

public class RecursionHanoi {
	public void towerOfHanoi(String start, String destination, String subBar, int n) {
		if(n <= 0)
			return;
		//
		towerOfHanoi(start, subBar, destination, n-1);
		System.out.println(n + "번 원반이" + start + "에서 " + destination + "로 옮깁니다.");
		towerOfHanoi(subBar, destination, start, n-1);
	}
	public static void main(String[] args) {
		RecursionHanoi test = new RecursionHanoi();
		test.towerOfHanoi("bar1", "bar2", "bar3", 4);
	}
}
