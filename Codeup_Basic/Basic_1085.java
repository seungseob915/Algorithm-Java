import java.util.Scanner;

public class Basic_1085 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int s = scan.nextInt();

		double stor = (double)(h) * b * c * s / (1024*1024*8);

		System.out.printf("%.1f MB", stor);
	}
}
