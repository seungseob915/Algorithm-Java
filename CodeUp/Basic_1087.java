import java.util.Scanner;

public class Basic_1087 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int s=1;
		int result=0;
		
		while(result<a) {
			result+=s;
			s++;
		}
		System.out.println(result);
	}
}
