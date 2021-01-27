import java.util.Arrays;
import java.util.Scanner;

public class Basic_1096 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int board[][]=new int[20][20];
		
		for(int i=0; i<n; i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			
			board[x][y]=1;
		}
		
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
