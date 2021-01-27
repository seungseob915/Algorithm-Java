import java.util.Arrays;
import java.util.Scanner;

public class Basic_1094 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt[]=new int[10001];
		
		for(int i=0; i<n; i++) {
			int in=scan.nextInt();
			cnt[i]=in;
		}
		for(int i=n-1; i>=0; i--) {
			System.out.print(cnt[i]+" ");
		}
	}
}
