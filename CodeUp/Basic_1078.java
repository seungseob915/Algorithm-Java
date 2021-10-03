import java.util.Scanner;

public class Basic_1078 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int s=1;
		int sum=0;
		while(s<=x) {
			if(s%2==0) sum+=s;
			s++;
		}
		System.out.println(sum);
	}
}
