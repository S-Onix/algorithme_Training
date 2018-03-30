package ArrayGravity;

public class Test {
	public static void main(String[] args) {
		for (int line = 0; line <6; line++) {
			for (int first = 5- line; first > line-6; first--) {
				if(first < 0)
					System.out.print(-first);
				else System.out.print(first);
			}
			System.out.println();
		}
		
		for(int line = 1; line < 6; line++) {
			for(int first = -line; first < line+1 ; first ++) {
				if(first < 0)
					System.out.print(-first);
				else System.out.print(first);
			}
			System.out.println();
		}
	}
}
