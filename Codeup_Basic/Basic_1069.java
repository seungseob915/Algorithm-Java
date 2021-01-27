import java.util.Scanner;

public class Basic_1069 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		char x=scan.nextLine().charAt(0);
		
		switch(x) {
		case 'A':
			System.out.println("best!!!");
			break;
		case 'B':
			System.out.println("good!!");
			break;
		case 'C':
			System.out.println("run!");
			break;
		case 'D':
			System.out.println("slowly~");
			break;
		default:
			System.out.println("what?");
			break;
		}
	}
}
