package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_3055 {
	static int visited[][][];
	static char board[][];
	static int start[]=new int[2];
	static int dx[]=new int[] {-1,0,1,0};
	static int dy[]=new int[] {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer st=new StringTokenizer(input, " ");
		
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		visited=new int[r][c][2];
		board=new char[r][c];
		
		// 1. 물부터 먼저 채워보자
		Queue<int[]> q=new LinkedList<int[]>();
		
		for(int i=0; i<r; i++) {
			String input2 = br.readLine();
			for(int j=0; j<c; j++) {
				char temp=input2.charAt(j);
				board[i][j]=temp;
				visited[i][j][1]=-1;
				
				if(temp=='S') { 
					start[0]=i; start[1]=j;
					visited[i][j][0]=-1;
				}
				else if(temp=='*') {
					q.offer(new int[] {i, j});
				}
				else if(temp=='X') {
					visited[i][j][0]=-2;
				}
				else {
					visited[i][j][0]=-1;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int nx=q.peek()[0];
			int ny=q.peek()[1];
			q.poll();
			
			for(int k=0; k<4; k++) {
				int nxtx=nx+dx[k];
				int nxty=ny+dy[k];
				
				if(nxtx<0 || nxtx>r-1 || nxty<0 || nxty>c-1) continue;
				if(visited[nxtx][nxty][0]!=-1) continue;
				if(board[nxtx][nxty]=='D') continue;
				
				q.offer(new int[] {nxtx, nxty});
				visited[nxtx][nxty][0]=visited[nx][ny][0]+1;
			}
		}
		
		// 2. 고슴도치 출발
		q.clear();
		int ans=0;
		boolean finish=false;
		
		q.offer(start);
		visited[start[0]][start[1]][1]=0;
		
		while(!q.isEmpty()) {
			int nx=q.peek()[0];
			int ny=q.peek()[1];
			q.poll();
			
			for(int k=0; k<4; k++) {
				int nxtx=nx+dx[k];
				int nxty=ny+dy[k];
				
				if(nxtx<0 || nxtx>r-1 || nxty<0 || nxty>c-1) continue;
				if(board[nxtx][nxty]=='X') continue;
				if(visited[nxtx][nxty][0]!=-1 && (visited[nx][ny][1]+1>=visited[nxtx][nxty][0])) continue;
				if(visited[nxtx][nxty][1]!=-1) continue;
				
				q.offer(new int[] {nxtx, nxty});
				visited[nxtx][nxty][1]=visited[nx][ny][1]+1;
				
				if(board[nxtx][nxty]=='D') {
					ans=visited[nxtx][nxty][1];
					finish=true;
					break;
				}
			}
			if(finish) break;
		}
		if(!finish)
			bw.write("KAKTUS");
		else
			bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
	}

}
