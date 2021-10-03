import java.util.Scanner;

public class Basic_1092 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int m = scan.nextInt();
		int d = scan.nextInt();
		int n = scan.nextInt();
		
		long result=a;
		
		for(int i=1; i<n; i++) {
			result=(result*m+d);
		}
		System.out.println(result);
		
	}
}
