package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_14502 {
	
	static int n, m;
	static int board[][];
	static int check[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int ret=-1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk=new StringTokenizer(br.readLine());
		n=Integer.parseInt(stk.nextToken());
		m=Integer.parseInt(stk.nextToken());
		
		board=new int[n][m];
		check=new int[n][m];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer stk1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(stk1.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}

	private static void dfs(int depth, int x, int y) {
		if(depth==3) {
			for(int i=0; i<n; i++) Arrays.fill(check[i], -1);
			ret=Math.max(ret, bfs());
			return;
		}
		
		for(int i=x; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j]==0) {
					board[i][j]=1;
					dfs(depth+1, i, j);
					board[i][j]=0;
				}
			}
		}
	}

	private static int bfs() {
		
		Queue<int[]> q=new LinkedList<int[]>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j]==2) {
					q.offer(new int[] {i, j});
					check[i][j]=0;
				}
			}
		}
		
		int t_ret=0;
		
		while(!q.isEmpty()) {
			int nowx=q.peek()[0];
			int nowy=q.peek()[1];
			
			q.poll();
			
			for(int d=0; d<4; d++) {
				int nxtx=nowx+dx[d];
				int nxty=nowy+dy[d];
				
				if(nxtx<0 || nxtx>n-1 || nxty<0 || nxty>m-1) continue;
				if(check[nxtx][nxty]!=-1) continue;
				if(board[nxtx][nxty]!=0) continue;
				
				q.offer(new int[] {nxtx, nxty});
				check[nxtx][nxty]=check[nowx][nowy]+1;
			}
		}
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(board[i][j]==0 && check[i][j]==-1)
					t_ret++;
		return t_ret;
	}

}
