import java.util.Scanner;

public class Basic_1093 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt[]=new int[24];
		
		for(int i=0; i<n; i++) {
			int in=scan.nextInt();
			cnt[in]++;
		}
		for(int i=1; i<=23; i++) {
			System.out.print(cnt[i]+" ");
		}
	}
}
