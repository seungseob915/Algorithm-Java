import java.util.Scanner;


public class Basic_1083 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++) {
			if(i%3==0) System.out.print("X ");
			else System.out.printf("%d ", i);
		}
	}
}
