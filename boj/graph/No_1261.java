package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1261 {
	static int board[][];
	static int visited[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[m][n];
		visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			String str1 = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = Character.getNumericValue(str1.charAt(j));
				visited[i][j]=-1;
			}
		}

		bfs();

		bw.write(String.valueOf(visited[m - 1][n - 1]));
		bw.flush();
		bw.close();
	}

	public static void bfs() {
		Deque<int[]> dq = new ArrayDeque<int[]>();

		dq.offerFirst(new int[] { 0, 0 });
		visited[0][0] = 0;

		while (!dq.isEmpty()) {
			int x = dq.peekFirst()[0];
			int y = dq.peekFirst()[1];
			dq.pollFirst();

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1)
					continue;
				if (visited[nx][ny] != -1)
					continue;
				if (board[nx][ny] == 0) {
					dq.offerFirst(new int[] { nx, ny });
					visited[nx][ny] = visited[x][y];
				} else {
					dq.offerLast(new int[] { nx, ny });
					visited[nx][ny] = visited[x][y] + 1;
				}
			}
		}
	}
}
