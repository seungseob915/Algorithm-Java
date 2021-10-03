import java.util.Scanner;

public class Basic_1086 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int b = scan.nextInt();
		int c = scan.nextInt();
		int s = scan.nextInt();

		double stor = (double)b * c * s / (1024*1024*8);

		System.out.printf("%.2f MB", stor);
	}
}
