import java.util.Scanner;

public class Basic_1098 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int board[][]=new int[101][101];
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();

		for(int i=1; i<=k; i++) {
			int l = scan.nextInt();
			int d = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			if(d==0) {
				for(int ii=0; ii<l; ii++) {
					board[x][y+ii]=1;
				}
			}
			else {
				for(int ii=0; ii<l; ii++) {
					board[x+ii][y]=1;
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
