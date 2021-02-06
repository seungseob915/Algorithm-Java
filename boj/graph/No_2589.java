package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No_2589 {
	static char board[][];
	static int visited[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int n, m;
	static int ret = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer stk = new StringTokenizer(input);

		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		board = new char[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str1 = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str1.charAt(j);
				visited[i][j] = -1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'L') {
					bfs(i, j);
					v_clean();
				}
			}
		}
		
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}

	
	private static void v_clean() {
		for(int i=0; i<n; i++)
			Arrays.fill(visited[i], -1);
	}


	private static void bfs(int i, int j) {

		int dist = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { i, j });
		visited[i][j] = 0;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1)
					continue;
				if (board[nx][ny] == 'W')
					continue;
				if (visited[nx][ny] > -1)
					continue;

				q.offer(new int[] { nx, ny });
				visited[nx][ny] = visited[x][y] + 1;
				dist = visited[nx][ny];
			}
		}

		ret = Math.max(ret, dist);
		
	}

}
