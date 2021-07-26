package kr.boj.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No20057 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, ans;
	static int A[][];
	static int typhoon[][][];
	static boolean chk[][];
	
	static int dx[]= {0,1,0,-1};
	static int dy[]= {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer stk=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stk.nextToken());
		
		A=new int[N+1][N+1];
		typhoon=new int[4][6][6];
		chk=new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			stk=new StringTokenizer(br.readLine());
			
			for(int j=1; j<=N; j++) {
				A[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		// typhoon 초기화
		typhoon[0][1][3]=2;
		typhoon[0][2][2]=10;
		typhoon[0][2][3]=7;
		typhoon[0][2][4]=1;
		typhoon[0][3][1]=5;
		typhoon[0][3][2]=-1;	// 알파
		typhoon[0][4][2]=10;
		typhoon[0][4][3]=7;
		typhoon[0][4][4]=1;
		typhoon[0][5][3]=2;
		
		int t_board[][]=new int[6][6];
		
		for(int dir=1; dir<4; dir++) {
			for(int i=1; i<=5; i++) {
				for(int j=1; j<=5; j++) {
					t_board[5-j+1][i]=typhoon[dir-1][i][j];
				}
			}
			typhoon[dir]=t_board;
			t_board=new int[6][6];
		}
		
		int sx=(N+1)/2;
		int sy=(N+1)/2;
		int sdir=0;
		chk[sx][sy]=true;
		sy--;
		wind(sx, sy, sdir);
		chk[sx][sy]=true;
		
		while(true) {
			if(sx==1 && sy==1)
				break;
			
			// 방향은 우선적으로 바꿔주고 만약 바꿨는데 방문을했던 지점이면 그대로가자
			int ndir=sdir+1;
			if(ndir==4) ndir=0;
			
			int nx=sx+dx[ndir];
			int ny=sy+dy[ndir];
			
			if(nx<1 || nx>N || ny<1 || ny>N) {
				nx=sx+dx[sdir];
				ny=sy+dy[sdir];
				ndir=sdir;
			}
			else if(chk[nx][ny]) {
				nx=sx+dx[sdir];
				ny=sy+dy[sdir];
				ndir=sdir;
			}
			sx=nx;
			sy=ny;
			sdir=ndir;
			
			chk[sx][sy]=true;
			wind(sx, sy, sdir);
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
	
	
	private static void wind(int sx, int sy, int sdir){
		int tp_x=3;
		int tp_y=3;
		
		int gap_x=sx-tp_x;
		int gap_y=sy-tp_y;
		
		int sand_amount=A[sx][sy];
		A[sx][sy]=0;
		
		if(sand_amount==0) 
			return;
		
		int minus_sand=0;
		
		int alph_x=0;
		int alph_y=0;
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(typhoon[sdir][i][j]==0) continue;
				if(typhoon[sdir][i][j]==-1) {
					alph_x=i+gap_x;
					alph_y=j+gap_y;
					continue;
				}
				
				int real_x=i+gap_x; 
				int real_y=j+gap_y;
				int ratio=typhoon[sdir][i][j];
				
				if(real_x<1 || real_x>N || real_y<1 || real_y>N) {
					minus_sand+=(sand_amount*ratio/100);
					ans+=(sand_amount*ratio/100);
				}
				else {
					A[real_x][real_y]+=(sand_amount*ratio/100);
					minus_sand+=(sand_amount*ratio/100);
				}
			}
		}
		
		if(alph_x<1 || alph_x >N || alph_y<1 || alph_y>N)
			ans+=(sand_amount-minus_sand);
		else {
			A[alph_x][alph_y]+=(sand_amount-minus_sand);
		}
	}


}
