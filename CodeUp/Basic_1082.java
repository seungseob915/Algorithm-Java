import java.util.Scanner;


public class Basic_1082 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int n=Integer.parseInt(s, 16);
		
		for (int i = 1; i <= 15; i++) {
			System.out.printf("%X*%X=%X\n", n, i, n * i);
		}
	}
}
