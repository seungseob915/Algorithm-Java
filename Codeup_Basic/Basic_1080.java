import java.util.Scanner;

public class Basic_1080 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int s=0;
		int result=0;
		
		while(true) {
			result+=s;
			if(result>=a) break;
			s++;
		}
		System.out.println(s);
	}
}
