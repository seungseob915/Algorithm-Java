import java.util.Scanner;

public class Basic_1088 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int s=1;
		
		while(s<=a) {
			if(s%3==0) {
				s++;
				continue;
			}
			System.out.println(s);
			s++;
		}
	}
}
