package kr.boj.hw3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int ans = 0, n, l, r;
	static int board[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		l = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(stk2.nextToken());
			}
		}

		while (check()) {
			ans++;
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	private static boolean check() {
		boolean ret = false;

		int newboard[][] = new int[n][n];
		boolean check[][] = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j]) 	continue;

				Queue<Point> q = new LinkedList<Point>();
				Queue<Point> rq = new LinkedList<Point>();

				int t_size = 0;
				int p_cnt = 0;

				q.offer(new Point(i, j));
				check[i][j]=true;
				
				while (!q.isEmpty()) {
					int x = q.peek().x;
					int y = q.peek().y;
					p_cnt += board[x][y];
					rq.offer(new Point(x, y));
					t_size++;
					
					q.poll();

					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];

						if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1)
							continue;
						if (check[nx][ny])
							continue;
						if (!(Math.abs(board[x][y] - board[nx][ny]) >= l && Math.abs(board[x][y] - board[nx][ny]) <= r))
							continue;

						q.offer(new Point(nx, ny));
						check[nx][ny]=true;
					}
				}
				if (t_size > 1) {
					ret = true;
					int rep = p_cnt / t_size;

					while (!rq.isEmpty()) {
						newboard[rq.peek().x][rq.peek().y] = rep;
						rq.poll();
					}
				}
				else {
					newboard[i][j]=board[i][j];
				}
			}
		}

		if (ret) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = newboard[i][j];
				}
			}
		}

		return ret;
	}

}
