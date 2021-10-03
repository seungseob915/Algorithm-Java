import java.util.Arrays;
import java.util.Scanner;

public class Basic_1097 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int board[][]=new int[20][20];
		
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				int n = scan.nextInt();
				board[i][j]=n;
			}
		}
		
		int u=scan.nextInt();
		for(int i=0; i<u; i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			for(int k=1; k<=19; k++) {
				if(board[x][k]==0) board[x][k]=1;
				else board[x][k]=0;
			}
			for(int k=1; k<=19; k++) {
				if(board[k][y]==0) board[k][y]=1;
				else board[k][y]=0;
			}
		}
		
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
