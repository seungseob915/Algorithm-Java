package kr.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1949 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int board[][];
	static boolean chk[][];
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	static int n, k, t, tcnt=1, ret=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		t=Integer.parseInt(br.readLine());
		
		while(t>0) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			n=Integer.parseInt(stk.nextToken());
			k=Integer.parseInt(stk.nextToken());
			ret=0;
			
			board=new int[n][n];
			chk=new boolean[n][n];
			int high=-1;
			
			for(int i=0; i<n; i++) {
				StringTokenizer stk2=new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					board[i][j]=Integer.parseInt(stk2.nextToken());
					if(board[i][j]>high)
						high=board[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(board[i][j]==high) {
						chk[i][j]=true;
						dfs(i, j, 1, false);
						chk[i][j]=false;
					}
						
				}
			}
			
			bw.write("#"+ tcnt++ +" "+String.valueOf(ret)+"\n");
			t--;
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int x, int y, int depth, boolean chance) {
		ret=Math.max(depth, ret);

		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			
			if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
			if(chk[nx][ny]) continue;
			
			if(board[nx][ny]<board[x][y]) {
				chk[nx][ny]=true;
				dfs(nx, ny, depth+1, chance);
				chk[nx][ny]=false;
			}
			else if(!chance && (board[nx][ny]-k < board[x][y])) {
				int temp=board[nx][ny];
				board[nx][ny]=board[x][y]-1;
				chk[nx][ny]=true;
				dfs(nx, ny, depth+1, true);
				chk[nx][ny]=false;
				board[nx][ny]=temp;
			}
		}
	}

}
