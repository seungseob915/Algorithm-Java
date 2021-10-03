
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No16235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int a[][];
	static int board[][];
	static Deque<Integer> tree[][];
	static int n, m, k;
	static int dx[] = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int dy[] = { -1, 1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());

		a = new int[n + 1][n + 1];
		board = new int[n + 1][n + 1];
		tree = new Deque[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				tree[i][j] = new ArrayDeque();
				a[i][j] = Integer.parseInt(stk2.nextToken());
				board[i][j]=5;
			}
		}

		for (int i = 1; i <= m; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk2.nextToken());
			int y = Integer.parseInt(stk2.nextToken());

			tree[x][y].offerFirst(Integer.parseInt(stk2.nextToken()));
		}
		
		while(k>0) {
			int f_board[][]=new int[n+1][n+1];
			
			// 봄여름
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(tree[i][j].isEmpty()) continue;

					int dead=0;
					int treesize=tree[i][j].size();
					for(int z=0; z<treesize; z++) {
						int now=tree[i][j].pollFirst();
						if(board[i][j]-now<0) {
							dead+=(now/2);
						}
						else {
							tree[i][j].offerLast(now+1);
							board[i][j]-=now;
							
							if((now+1)%5==0)
								f_board[i][j]++;
						}
					}
					board[i][j]+=dead;
				}
			}
			
			// 가을
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(f_board[i][j]==0) continue;
					
					int now = f_board[i][j];
					while (now > 0) {
						for(int d=0; d<8; d++) {
							int nx=i+dx[d];
							int ny=j+dy[d];
							if(nx<1 || nx>n || ny<1 || ny>n) continue;
							tree[nx][ny].offerFirst(1);
						}
						now--;
					}
				}
			}
			
			// 겨울
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					board[i][j]+=a[i][j];
				}
			}
			
			k--;
		}
		
		int ret=0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				ret+=tree[i][j].size();
			}
		}
		
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}

}
