import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
	static int [][] board;
	static int dx[]={0, 0, -1, 1};
	static int dy[]={1, -1, 0, 0};
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		while(true){

			int T=Integer.parseInt(br.readLine());


			int sx=0;
			int sy=0;
			int ex=0;
			int ey=0;
			boolean isFin=false;

			board=new int[16][16];

			for(int i=0; i<16; i++){
				String stk=br.readLine();
				for(int j=0; j<16; j++){
					board[i][j]=stk.charAt(j)-'0';

					if(board[i][j]==2){
						sx=i;
						sy=j;
					}
					else if(board[i][j]==3){
						ex=i;
						ey=j;
					}
				}
			}

			Queue<int[]> q=new LinkedList<>();
			q.add(new int[]{sx, sy});

			boolean chk[][]=new boolean[16][16];
			chk[sx][sy]=true;

			Outer: while (!q.isEmpty()){
				int[] now=q.poll();

				for(int dir=0; dir<4; dir++){
					int nx=now[0]+dx[dir];
					int ny=now[1]+dy[dir];

					if(nx<0 || nx>15 || ny<0 || ny>15)
						continue;
					if(chk[nx][ny])
						continue;
					if(board[nx][ny]==1)
						continue;
					if(nx==ex && ny==ey) {
						isFin=true;
						break Outer;
					}
					q.add(new int[]{nx, ny});
					chk[nx][ny]=true;
				}
			}

			bw.write(  "#"+T+ " " + (isFin ? "1":"0") + "\n");

			if(T==10)
				break;
		}
		bw.flush();
		bw.close();
	}
}
