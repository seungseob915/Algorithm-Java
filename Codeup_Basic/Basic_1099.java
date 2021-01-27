import java.util.Scanner;

public class Basic_1099 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int board[][]=new int[11][11];

		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				int t=scan.nextInt();
				board[i][j]=t;
			}
		}
		
		int x=2, y=2;
		
		while(true) {
			if(board[2][2]==2) {
				board[2][2]=9;
				break;
			}
			board[2][2]=9;
			if(board[x][y+1]==0) {
				y=y+1;
				board[x][y]=9;
			}
			else if(board[x][y+1]==2) {
				y+=1;
				board[x][y]=9;
				break;
			}
			else {
				x+=1;
				if(board[x][y]==2) {
					board[x][y]=9;
					break;
				}
				else if(board[x][y]==0) {
					board[x][y]=9;
				}
				else
					break;
			}
		}
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
