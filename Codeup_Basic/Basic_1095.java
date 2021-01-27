import java.util.Arrays;
import java.util.Scanner;

public class Basic_1095 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int chk[]=new int[24];
		
		for(int i=0; i<n; i++) {
			int in=scan.nextInt();
			chk[in]++;
		}
		for(int i=0; i<n; i++) {
			if(chk[i]!=0) {
				System.out.print(i);
				break;
			}
		}
	}
}
