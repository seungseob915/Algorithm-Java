package kr.boj.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No20058 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, Q, f_ans=0, s_ans=0;
	static int A[][];
	
	static int dx[]= {-1, 0, 0, 1};
	static int dy[]= {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer stk=new StringTokenizer(br.readLine());
		N=(int) Math.pow(2,Integer.parseInt(stk.nextToken()));
		Q=Integer.parseInt(stk.nextToken());
		A=new int[N][N];
		
		for(int i=0; i<N; i++) {
			stk=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		stk=new StringTokenizer(br.readLine());
		
		for(int t=0; t<Q; t++) {
			int size=(int)Math.pow(2, Integer.parseInt(stk.nextToken()));
			
			if(size!=1) {
				QuadTree(0,0,N,size);
			}
	
			CheckIce();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(A[i][j]>0)
					f_ans+=A[i][j];
			}
		}
		
		boolean chk[][]=new boolean[N][N];

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(A[i][j]==0) continue;
				if(chk[i][j]) continue;
				
				int group_cnt=1;
				
				Queue q=new LinkedList<int[]>();
				q.add(new int[]{i, j});
				chk[i][j]=true;
				
				while(!q.isEmpty()) {
					int[] now=(int[]) q.poll();
					
					for(int dir=0; dir<4; dir++) {
						int nx=now[0]+dx[dir];
						int ny=now[1]+dy[dir];
						
						if(nx<0 || nx>N-1 || ny<0 || ny>N-1)
							continue;
						if(chk[nx][ny])
							continue;
						if(A[nx][ny]==0)
							continue;
						
						q.add(new int[] {nx,ny});
						chk[nx][ny]=true;
						group_cnt++;
					}
				}
				s_ans=Math.max(s_ans, group_cnt);
			}
		}
		bw.write(String.valueOf(f_ans)+"\n"+String.valueOf(s_ans));
		bw.flush();
		bw.close();
	}

	private static void CheckIce() {
		List<int[]> minus=new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(A[i][j]==0) continue;
				
				int near=0;
				
				for(int dir=0; dir<4; dir++) {
					int nx=i+dx[dir];
					int ny=j+dy[dir];
					
					if(nx<0 || nx>N-1 || ny<0 || ny>N-1)
						continue;
					if(A[nx][ny]>0)
						near++;
				}
				
				if(near<3)
					minus.add(new int[] {i, j});
			}
		}
		
		for(int i=0; i<minus.size(); i++)
			A[minus.get(i)[0]][minus.get(i)[1]]--;
	}

	private static void QuadTree(int x, int y, int size, int goal_size) {
		if(size==goal_size) {
			rotate_block(x, y, size);
			return;
		}
		
		int nsize=size/2;
		
		QuadTree(x, y, nsize, goal_size);
		QuadTree(x, y+nsize, nsize, goal_size);
		QuadTree(x+nsize, y, nsize, goal_size);
		QuadTree(x+nsize, y+nsize, nsize, goal_size);
	}

	private static void rotate_block(int x, int y, int size) {
		int t_board[][]=new int[size][size];
		int board[][]=new int[size][size];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				t_board[i-x][j-y]=A[i][j];
			}
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				board[j][size-i-1]=t_board[i][j];
			}
		}
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				A[i][j]=board[i-x][j-y];
			}
		}
	}
}
