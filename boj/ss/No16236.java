package kr.boj.ss;

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

class Shark {
	int x;
	int y;
	int size;
	int lvl_up;
}

public class No16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int board[][];
	static int n, time = 0;
	static Shark shark;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());

		board = new int[n][n];
		shark = new Shark();
		shark.size = 2;

		for (int i = 0; i < n; i++) {
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(stk2.nextToken());
				if (board[i][j] == 9) {
					shark.x = i;
					shark.y = j;
					shark.lvl_up = 0;
					board[i][j]=0;
				}
			}
		}

		while (go()) {
		}

		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
	}

	private static boolean go() {

		boolean fish_catch = false;
		int chk[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(chk[i], -1);

		int x = shark.x;
		int y = shark.y;
		int limit=-1;
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		chk[x][y] = 0;
		
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (fish_catch && chk[now.x][now.y]==limit)	continue;
			
			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];

				if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1)
					continue;
				if (chk[nx][ny] != -1)
					continue;
				if (board[nx][ny] > shark.size)
					continue; // 물고기가 상어보다 크면 못지나감
				// 나보다 작은 물고기를 찾았다면 (더이상 queue에 넣지 않고, x y값을 비교해준다)
				if (board[nx][ny] != 0 && board[nx][ny] < shark.size) {
					// 처음 찾았다면
					if(!fish_catch) {
						shark.x = nx;
						shark.y = ny;
						fish_catch = true;
						limit=chk[now.x][now.y] + 1;
					}
					// 2번째 이상이라면
					else {
						if(shark.x>nx) {
							shark.x=nx;
							shark.y=ny;
						}
						else if(shark.x==nx) {
							if(shark.y>ny) {
								shark.y=ny;
							}
						}
					}
					chk[nx][ny] = chk[now.x][now.y] + 1;
				}
				if (fish_catch)	continue;
				queue.offer(new Point(nx, ny));
				chk[nx][ny] = chk[now.x][now.y] + 1;
			}
		}

		if (fish_catch) {
			shark.lvl_up++;
			if (shark.lvl_up == shark.size) {
				shark.size++;
				shark.lvl_up = 0;
			}
			time += (chk[shark.x][shark.y]);
			board[shark.x][shark.y] = 0;
		}
		return fish_catch;
	}

}
