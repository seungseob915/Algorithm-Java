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

public class No_2667 {
	static int board[][];
	static int visited[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int n;
	static LinkedList<Integer> hcnt=new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		n=Integer.parseInt(br.readLine());

		board = new int[n][n];
		visited = new int[n][n];

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			String str1 = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = Character.getNumericValue(str1.charAt(j));
				visited[i][j] = 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != 0 || board[i][j] != 1)	continue;
				bfs(i, j, ++cnt);
			}
		}
		
		bw.write(String.valueOf(cnt) + "\n");
		Collections.sort(hcnt);
		Iterator<Integer> it = hcnt.listIterator();

		while (it.hasNext())
			bw.write(String.valueOf(it.next()) + "\n");
		bw.flush();
		bw.close();
	}

	public static void bfs(int i, int j, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		int ccnt=0;
		q.offer(new int[] { i, j });
		visited[i][j] = cnt;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			ccnt++;

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1)	continue;
				if (board[nx][ny] == 0)	continue;
				if (visited[nx][ny] != 0)	continue;

				q.offer(new int[] { nx, ny });
				visited[nx][ny] = cnt;
			}
		}
		hcnt.add(ccnt);
	}
	
}
