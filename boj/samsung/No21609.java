
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
	int x;
	int y;

	public Position() {
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Block_Cnt {
	int num;
	int rainbow_cnt;

	public Block_Cnt() {
	}

	public Block_Cnt(int num, int rainbow_cnt) {
		this.num = num;
		this.rainbow_cnt = rainbow_cnt;
	}
}

public class No21609 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M, ans;
	static int board[][];
	static int check[][];

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		board = new int[N + 1][N + 1];
		check = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		boolean go = true;

		// simulation 시작
		while (go) {

			for (int i = 1; i <= N; i++)
				Arrays.fill(check[i], 0);

			// 1. 그룹 검색
			int max_group_size = 0;
			int group_cnt = 0;
			List<Block_Cnt> candidate = new LinkedList<Block_Cnt>(); // 없앨 후보들 담자

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (board[i][j] < 1)
						continue; // 일반 블록일때만 취급하자(최소 1개가 있어야 하니까)
					if (check[i][j] != 0)
						continue;

					Queue<Position> q = new LinkedList<Position>();
					q.add(new Position(i, j));
					check[i][j] = (++group_cnt);
					int group_size = 1;
					int now_color = board[i][j];
					int rainbow_cnt = 0;

					while (!q.isEmpty()) {
						Position p = q.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = p.x + dx[dir];
							int ny = p.y + dy[dir];

							if (nx < 1 || nx > N || ny < 1 || ny > N)
								continue;
							if (!(board[nx][ny] == now_color || board[nx][ny] == 0))
								continue;
							if (check[nx][ny] != 0)
								continue;

							q.add(new Position(nx, ny));
							check[nx][ny] = group_cnt;
							group_size++;
							if (board[nx][ny] == 0)
								rainbow_cnt++;
						}
					}
					if (group_size > 1 && max_group_size < group_size) {
						candidate.clear();
						candidate.add(new Block_Cnt(group_cnt, rainbow_cnt));
						max_group_size = group_size;
					} else if (group_size > 1 && max_group_size == group_size) {
						candidate.add(new Block_Cnt(group_cnt, rainbow_cnt));
					}
					for (int k = 1; k <= N; k++) {
						for (int kk = 1; kk <= N; kk++) {
							if (board[k][kk] == 0)
								check[k][kk] = 0;
						}
					}
				}
			}

			if (max_group_size == 0) {
				go = false;
				break;
			}

			else if (candidate.size() == 1) {
				ans += Math.pow(remove_block(candidate.get(0).num), 2);
			}

			else {
				int max_rainbow = 0;

				for (int i = 0; i < candidate.size(); i++) {
					max_rainbow = Math.max(max_rainbow, candidate.get(i).rainbow_cnt);
				}

				List<Integer> cl = new LinkedList<Integer>();
				for (int i = 0; i < candidate.size(); i++) {
					if (max_rainbow == candidate.get(i).rainbow_cnt)
						cl.add(candidate.get(i).num);
				}

				// rainbow 큰게 한개이면
				if (cl.size() == 1) {
					ans += Math.pow(remove_block(cl.get(0)), 2);
				}
				// 아니면 -> 기준점 비교
				else {
					int sx = 0;
					int sy = 0;
					int now = 0;

					for (int i = 0; i < cl.size(); i++) {
						Position p = check_standard(cl.get(i));
						if (p.x > sx) {
							now = cl.get(i);
							sx = p.x;
							sy = p.y;
						} else if (p.x == sx) {
							if (p.y > sy) {
								now = cl.get(i);
								sx = p.x;
								sy = p.y;
							}
						}
					}
					ans += Math.pow(remove_block(now), 2);
				}
			}

			// 2. 내리기
			down();

			// 3. 회전
			rotate();

			// 4. 내리기
			down();

		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	
	
	
	private static int remove_block(int num) {
		int score = 0;
		boolean chk[][] = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (check[i][j] == num) {
					Queue<Position> q = new LinkedList<Position>();
					q.add(new Position(i, j));
					chk[i][j] = true;
					board[i][j] = -2;
					score++;
					
					while (!q.isEmpty()) {
						Position n = q.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = n.x + dx[dir];
							int ny = n.y + dy[dir];

							if (nx < 1 || nx > N || ny < 1 || ny > N)
								continue;
							if (!(board[nx][ny] == 0 || check[nx][ny] == num))
								continue;
							if (chk[nx][ny])
								continue;
							q.add(new Position(nx, ny));
							chk[nx][ny] = true;
							board[nx][ny] = -2;
							score++;
						}
					}
					return score;
				}
			}
		}
		return score;
	}

	private static Position check_standard(int num) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (check[i][j] == num && board[i][j] > 0) {
					return new Position(i, j);
				}
			}
		}
		return new Position(0, 0);
	}

	// 내리기
	private static void down() {
		for (int i = 1; i <= N; i++) {
			for (int j = N; j >= 2; j--) {
				if (board[j][i] == -2) {
					for (int k = j - 1; k >= 1; k--) {
						if (board[k][i] == -1)
							break;
						if (board[k][i] == -2)
							continue;
						if (board[k][i] >= 0) {
							board[j][i] = board[k][i];
							board[k][i] = -2;
							break;
						}
					}
				}
			}
		}
	}

	// 회전시키기
	private static void rotate() {
		int t_board[][] = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				t_board[N - j + 1][i] = board[i][j];
			}
		}

		board = t_board;
	}

}
