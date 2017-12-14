import java.util.Scanner;

public class sol2439 {
	public static void main(String [] args) {
		Scanner scan  = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i = 0; i< n; i++) {
			//스페이스바 영역
			for(int k = n-i-1; k > 0 ; k--) {
				System.out.print(" ");
			}
			//별 영역
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
}
