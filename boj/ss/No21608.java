package kr.boj.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*class Position{
	int x;
	int y;
	
	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}*/

class Candidate_List{
	int x;
	int y;
	int empty;
	
	public Candidate_List() {
	}
	public Candidate_List(int x, int y, int empty) {
		this.x = x;
		this.y = y;
		this.empty = empty;
	}
	
}


public class No21608 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int board[][]; // 보드
	static int friend[][]; // 좋아하는 친구
	static int order[];
	static Map<Integer, Position> location;
	
	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		board = new int[N + 1][N + 1];
		friend = new int[N * N + 1][5];
		order = new int[N * N + 1];
		location = new HashMap<Integer, Position>();
		
		for (int i = 1; i <= N * N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			order[i] = Integer.parseInt(stk.nextToken());
			
			for (int j = 1; j <= 4; j++) {
				friend[order[i]][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		
		//시작 (첫시작은 무조건 2,2)
		board[2][2]=order[1];
		location.put(order[1], new Position(2,2));
		
		// 배치 시작
		for(int i=2; i<=N*N; i++) {
			int now=order[i];	// 학생번호
			int most_cnt=0;
			
			List<Candidate_List> cl=new LinkedList<Candidate_List>();	//most_cnt비교 위한 리스트
			
			// 1. 좋아하는 친구  가장 많은 칸 찾기 + 2. 빈칸까지 같이 저장하자
			for(int x=1; x<=N; x++) {
				for(int y=1; y<=N; y++) {
					if(board[x][y]!=0) continue;
					
					int now_cnt=0;
					int empty=0;
					
					// 주변 친구있는지 탐색
					for(int k=0; k<4; k++) {
						int nx=x+dx[k];
						int ny=y+dy[k];
						
						if(nx<1 || nx>N || ny<1 || ny>N) continue;
						if(board[nx][ny]==0) {
							empty++;
							continue;
						}
						
						for(int d=1; d<=4; d++) {
							if(friend[now][d]==board[nx][ny]) {
								now_cnt++;
								break;
							}
						}
					}
					
					if(now_cnt>most_cnt) {
						most_cnt=now_cnt;
						cl.clear();
						cl.add(new Candidate_List(x, y, empty));
					}
					else if(now_cnt==most_cnt) {
						cl.add(new Candidate_List(x, y, empty));
					}
				}
			}
			// 2. 비어있는 칸이 가장 많은 곳			
			if(cl.size() > 1) {
				int max_empty=-1;
				
				for(int chk=0; chk<cl.size(); chk++) {
					max_empty=Math.max(max_empty, cl.get(chk).empty);
				}
				
				int max_cnt=0;
				int nextx=-1;
				int nexty=-1;
				for(int chk=0; chk<cl.size(); chk++) {
					if(max_empty==cl.get(chk).empty) {
						max_cnt++;
						if(max_cnt>1)
							break;
						nextx=cl.get(chk).x;
						nexty=cl.get(chk).y;
					}
				}
				// 위치선정 (2, 3케이스)				
				board[nextx][nexty]=now;
				location.put(now, new Position(nextx, nexty));
			}
			// 1번에서 종료되면
			else {
				board[cl.get(0).x][cl.get(0).y]=now;
				location.put(now, new Position(cl.get(0).x, cl.get(0).y));
			}
		}
		
		int ans=0;
		
		for(int i=1; i<=N*N; i++) {
			int near=0;
			int n=order[i];
			int nx=location.get(n).x;
			int ny=location.get(n).y;
			
			for(int j=1; j<=4; j++) {
				int f=friend[n][j];
				int fx=location.get(f).x;
				int fy=location.get(f).y;
				
				int dis=Math.abs(nx-fx) + Math.abs(ny-fy);
				if(dis==1)
					near++;
			}
			
			if(near==1) {
				ans++;
			}
			else if(near==2) {
				ans+=10;
			}
			else if(near==3) {
				ans+=100;
			}
			else if(near==4) {
				ans+=1000;
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

}
