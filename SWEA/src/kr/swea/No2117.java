package kr.swea;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2117 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int board[][];
	static int chk[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int t, tcnt = 1, n, m, ret = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());

		while (t > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			board = new int[n][n];
			ret = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer sk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(sk.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i, j);
				}
			}

			bw.write("#" + tcnt++ + " " + String.valueOf(ret) + "\n");
			t--;
		}
		bw.flush();
		bw.close();
	}

	private static void bfs(int x, int y) {

		for (int s = 1; s <= n + 1; s++) {
			chk = new int[n][n];
			Queue<Point> q = new LinkedList<Point>();

			q.offer(new Point(x, y));
			chk[x][y] = 1;
			
			if (chk[x][y] != s) {
				while (!q.isEmpty()) {
					int nowx = q.peek().x;
					int nowy = q.peek().y;
					q.poll();

					for (int d = 0; d < 4; d++) {
						int nx = nowx + dx[d];
						int ny = nowy + dy[d];

						if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1)
							continue;
						if (chk[nx][ny] != 0)
							continue;

						chk[nx][ny] = chk[nowx][nowy] + 1;

						if (chk[nx][ny] == s)
							continue;
						q.offer(new Point(nx, ny));
					}
				}
			}

			int cost = s * s + (s - 1) * (s - 1);
			int house_cnt = 0;
			if(s==1) cost=1;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (chk[i][j] != 0 && board[i][j] == 1)
						house_cnt++;
				}
			}

			int profit = house_cnt * m;
			if (profit - cost >= 0)
				ret = Math.max(ret, house_cnt);
		}
	}

}
