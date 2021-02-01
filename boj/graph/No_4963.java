package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No_4963 {
	static boolean visited[][];
	static int arr[][];
	static int[] dx = new int[] { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0, 1, -1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String[] input = br.readLine().split(" ");
			int w = Integer.parseInt(input[0]);
			int h = Integer.parseInt(input[1]);

			if (input.length == 2 && w == 0 && h == 0)
				break;

			arr = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			int cnt = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j]==0 || visited[i][j])	continue;
					bfs(i, j);
					cnt++;
				}
			}

			bw.write(String.valueOf(cnt));
			bw.newLine();
			bw.flush();

		}
		bw.close();
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int nx = q.peek()[0];
			int ny = q.peek()[1];
			q.poll();

			for (int k = 0; k < 8; k++) {
				int nxx = nx + dx[k];
				int nxy = ny + dy[k];

				if (nxx < 0 || nxx > arr.length - 1 || nxy < 0 || nxy > arr[0].length - 1)
					continue;
				if (visited[nxx][nxy])
					continue;
				if (arr[nxx][nxy] != 1)
					continue;

				q.offer(new int[] { nxx, nxy });
				visited[nxx][nxy] = true;
			}

		}
	}
}
