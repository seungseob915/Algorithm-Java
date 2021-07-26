package kr.boj.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No21611 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	static int N, M, ans;
	static int board[][][];	// 0: 보드 번호  1: 구슬 번호
	static int ball[];	// 구슬번호
	static int score_cnt[];
	
	static int dx[]= {0,-1,1,0,0};
	static int dy[]= {0,0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer stk=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		board=new int[N+1][N+1][2];
		ball=new int[N*N];
		score_cnt=new int[4];
		
		for(int i=1; i<=N; i++) {
			stk=new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				board[i][j][1]=Integer.parseInt(stk.nextToken());
				board[i][j][0]=-1;
			}
		}
		
		
		int sx=(N+1)/2;
		int sy=(N+1)/2;
		board[sx][sy][0]=0;
		board[sx][sy][1]=-1;
		ball[0]=-1;
		
		sy--;
		int sdir=3;
		int b_cnt=1;

		// 보드에 번호 주입 + 구슬번호 1차배열로 전환
		while(true) {
			ball[b_cnt]=board[sx][sy][1];
			board[sx][sy][0]=b_cnt++;
			if(sx==1 && sy==1)
				break;
			
			int ndir=0;
			
			// 방향전환 90도			
			if(sdir==3)	ndir=2;
			else if(sdir==2) ndir=4;
			else if(sdir==4) ndir=1;
			else if(sdir==1) ndir=3;
			
			// 방향전환 90도했을때, 다음좌표
			int nx=sx+dx[ndir];
			int ny=sy+dy[ndir];
			
			if(board[nx][ny][0]!=-1) {
				sx=sx+dx[sdir];
				sy=sy+dy[sdir];
			}
			else {
				sx=nx;
				sy=ny;
				sdir=ndir;
			}
		}
		
		//상어 위치
		sx=(N+1)/2;
		sy=(N+1)/2;
		
		for(int t=0; t<M; t++) {
			stk=new StringTokenizer(br.readLine());
			
			int d=Integer.parseInt(stk.nextToken());
			int s=Integer.parseInt(stk.nextToken());
			
			List<Integer> ls=new ArrayList<Integer>();	// 삭제된 위치
			
			for(int k=1; k<=s; k++) {
				int x=sx+dx[d]*k;
				int y=sx+dy[d]*k;
				
				ball[board[x][y][0]]=0;
				ls.add(board[x][y][0]);
			}
			
			
			// 2. 빈칸이동
			move_ball(ls);
			
			// 3. 구슬 폭발 + 4. 빈칸이동
			fire_ball();
			
			// 5. A, B 구슬로 변환
			convert_ball();
		}
		
		ans=score_cnt[1]+score_cnt[2]*2+score_cnt[3]*3;
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
	
	// 구슬 폭발
	static private void fire_ball(){
		
		List<Integer> ls=new ArrayList<Integer>();
		
		// 연속되는 4개 찾기
		for(int i=1; i<=N*N-4; i++) {
			int start_idx=i;
			int start_value=ball[start_idx];
			int thing_idx=i+1;
			int same=1;
			
			if(start_value==0)
				continue;
			
			while(thing_idx<N*N) {
				if(ball[thing_idx]!=start_value)
					break;
				same++;
				thing_idx++;
			}
			
			if(same>=4) {
				for(int j=start_idx; j<start_idx+same; j++) {
					score_cnt[ball[j]]++;
					ball[j]=0;
					ls.add(j);
				}
				i=start_idx+same-1;
			}
		}
		
		if(ls.size()>0) {
			move_ball(ls);
			fire_ball();
		}
		else {
			return;
		}
	}
	
	// 구슬 빈칸 이동
	static private void move_ball(List<Integer> ls) {
		for(int i=ls.size()-1; i>=0; i--) {
			int standard=ls.get(i);
			
			for(int j=standard; j<N*N-1; j++) {
				ball[j]=ball[j+1];
			}
			ball[N*N-1]=0;
		}
	}
	
	static private void convert_ball() {
		int t_ball[]=new int[N*N];
		t_ball[0]=-1;
		int t_ball_idx=0;
		
		for(int i=1; i<N*N; i++) {
			int now=ball[i];
			if(now==0)
				break;
			int next=i+1;
			int cnt=1;
			
			while(next < N*N && ball[next]==now) {
				cnt++;
				next++;
			}
			
			t_ball_idx++;
			if(t_ball_idx>=N*N) 
				break;
			t_ball[t_ball_idx++]=cnt;

			if(t_ball_idx>=N*N) 
				break;
			t_ball[t_ball_idx]=now;
			
			i=i+cnt-1;
		}
		
		ball=t_ball;
	}
}
