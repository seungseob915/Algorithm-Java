import java.util.Scanner;

public class Basic_1090 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int d = scan.nextInt();
		int n = scan.nextInt();
		long result=a*(long)Math.pow(d, n-1);
		System.out.println(result);
	}
}
