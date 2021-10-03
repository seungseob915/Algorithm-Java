import java.util.Scanner;

public class Basic_1070 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		
		switch(x) {
		case 12:
		case 1:
		case 2:
			System.out.println("winter");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("spring");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("summer");
			break;
		default:
			System.out.println("fall");
			break;
		}
	}
}
