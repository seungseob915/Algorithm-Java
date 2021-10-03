import java.util.Scanner;

public class Basic_1068 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		
		if(x>=90)	System.out.println("A");
		else if(x>=70) 	System.out.println("B");
		else if(x>=40) 	System.out.println("C");
		else 	System.out.println("D");
		}

}
