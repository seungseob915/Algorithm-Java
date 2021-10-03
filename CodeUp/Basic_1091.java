import java.util.Scanner;

public class Basic_1091 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		
		System.out.println(lcm(lcm(a,b),c));
		
	}
	
	public static int gcd(int a, int b){
		if(a<b) gcd(b, a);
		if(a%b==0) return b;
		return gcd(b, a%b);
	}

	public static int lcm(int a, int b){
	    return a * b / gcd(a,b);
	}
}
