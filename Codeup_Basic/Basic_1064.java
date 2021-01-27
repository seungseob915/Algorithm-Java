import java.util.Scanner;

public class Basic_1064 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		int z=scan.nextInt();
		
		System.out.println((x>y?y:x)>z?z:(x>y?y:x));
	}

}
