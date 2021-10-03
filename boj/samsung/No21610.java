
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Location{
	int x;
	int y;
	
	public Location() {
	}
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class No21610 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, M, ans;
	static int A[][];
	static boolean cloud_chk[][];
	static List<Location> cloud_location;
	
	static int dx[]= {0, 0,-1,-1,-1,0,1,1,1};
	static int dy[]= {0, -1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		StringTokenizer stk=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		A=new int[N+1][N+1];	
		cloud_location=new ArrayList<Location>();
		cloud_chk=new boolean[N+1][N+1];
		
		cloud_location.add(new Location(N, 1));
		cloud_location.add(new Location(N, 2));
		cloud_location.add(new Location(N-1, 1));
		cloud_location.add(new Location(N-1, 2));
		
		for(int i=1; i<=N; i++) {
			stk=new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				A[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i=1; i<=M; i++) {
			stk=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(stk.nextToken());
			int s=Integer.parseInt(stk.nextToken());
			
			// 1. 모든 구름 이동 +  2. 물의양 증가  + 3. 구름삭제  + 4. 물증가
			move_cloud(d, s);
			
			make_cloud();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				ans+=A[i][j];
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
	
	
	// 구름이동 + 물 증가 + 구름삭제 및 위치 저장
	static private void move_cloud(int d, int s) {
		
		for(int i=0; i<cloud_location.size(); i++) {
			int tx=cloud_location.get(i).x;
			int ty=cloud_location.get(i).y;
			
			int nx=(tx+dx[d]*s)%N;
			int ny=(ty+dy[d]*s)%N;
			
			if(nx==0) nx=N;
			if(ny==0) ny=N;

			if(nx<0) nx=N+nx;
			if(ny<0) ny=N+ny;
			
			// 구름이동한 위치
			cloud_location.set(i, new Location(nx,ny));
			
			// 물 증가
			A[nx][ny]++;
			
			// 5)에서 중복되지 않게 체크
			cloud_chk[nx][ny]=true;
		}
		
		//4. 물증가
		for(int i=0; i<cloud_location.size(); i++) {
			int x=cloud_location.get(i).x;
			int y=cloud_location.get(i).y;
			
			int water_cnt=0;
			
			for(int dir=2; dir<=8; dir+=2) {
				int nx=x+dx[dir];
				int ny=y+dy[dir];
				
				if(nx<1 || nx>N || ny<1 || ny>N) continue;
				if(A[nx][ny]>0)
					water_cnt++;
			}
			A[x][y]+=water_cnt;
		}
		
		cloud_location.clear();
	}
	
	
	static private void make_cloud() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(cloud_chk[i][j]) {
					cloud_chk[i][j]=false;
					continue;
				}
				
				if(A[i][j]>=2) {
					cloud_location.add(new Location(i,j));
					A[i][j]-=2;
				}
				
			}
		}
	}
}