import java.util.Scanner;

public class Basic_1076 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		char x=scan.nextLine().charAt(0);
		char s='a';
		while(s<=x) {
			System.out.println(s++);
		}
	}
}
