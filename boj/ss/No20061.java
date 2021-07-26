package kr.boj.ss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No20061 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, f_ans = 0, s_ans = 0;
	static int board[][][];

	public static void main(String[] args) throws IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());

		board = new int[2][10][10]; // 0: 1번째(아래) / 1 : 2번째
		int turn = 0;

		while (N > 0) {
			stk = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(stk.nextToken());
			int sx = Integer.parseInt(stk.nextToken());
			int sy = Integer.parseInt(stk.nextToken());

			turn++;

			first_area(turn, t, sx, sy);
			second_area(turn, t, sy, sx);

			N--;
		}

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (board[k][i][j] != 0)
						s_ans++;
				}
			}
		}
		bw.write(String.valueOf(f_ans + "\n" + s_ans));
		bw.flush();
		bw.close();
	}

	private static void first_area(int turn, int t, int sx, int sy) {
		// 블럭 쌓기
		if (t == 1) {
			for (int i = 6; i <= 9; i++) {
				if (i == 9 && board[0][i][sy] == 0) {
					board[0][i][sy] = turn;
					break;
				}
				if (board[0][i][sy] != 0) {
					board[0][i - 1][sy] = turn;
					break;
				}
			}
		} else if (t == 2) {
			for (int i = 6; i <= 9; i++) {
				if (i == 9 && (board[0][i][sy] == 0 && board[0][i][sy + 1] == 0)) {
					board[0][i][sy] = turn;
					board[0][i][sy + 1] = turn;
					break;
				}
				if (board[0][i][sy] != 0 || board[0][i][sy + 1] != 0) {
					board[0][i - 1][sy] = turn;
					board[0][i - 1][sy + 1] = turn;
					break;
				}
			}
		} else {
			for (int i = 6; i <= 9; i++) {
				if (i == 9 && (board[0][i][sy] == 0)) {
					board[0][i][sy] = turn;
					board[0][i - 1][sy] = turn;
					break;
				}
				if (board[0][i][sy] != 0) {
					board[0][i - 1][sy] = turn;
					board[0][i - 2][sy] = turn;
					break;
				}
			}
		}

		for (int i = 6; i <= 9; i++) {
			int chk_cnt = 0;
			for (int j = 0; j < 4; j++) {
				if (board[0][i][j] != 0)
					chk_cnt++;
			}
			// 없애고 내리자
			if (chk_cnt == 4) {
				f_ans++;
				for (int x = i; x >= 4; x--) {
					for (int y = 0; y < 4; y++) {
						if (x == 4)
							board[0][x][y] = 0;
						else
							board[0][x][y] = board[0][x - 1][y];
					}
				}
			}
		}

		int del_cnt = 0;
		// 만약 4~5구간에 있을 때
		for (int i = 4; i <= 5; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[0][i][j] != 0) {
					del_cnt++;
					break;
				}
			}
		}

		if (del_cnt == 2) {
			for (int i = 9; i >= 6; i--) {
				for (int j = 0; j < 4; j++) {
					board[0][i][j] = board[0][i - 2][j];
				}
			}

			for (int i = 4; i <= 5; i++) {
				for (int j = 0; j < 4; j++) {
					board[0][i][j] = 0;
				}
			}
		} else if (del_cnt == 1) {
			for (int i = 9; i >= 6; i--) {
				for (int j = 0; j < 4; j++) {
					board[0][i][j] = board[0][i - 1][j];
				}
			}

			for (int j = 0; j < 4; j++) {
				board[0][5][j] = 0;
			}
		}
	}

	private static void second_area(int turn, int t, int sx, int sy) {
		// 블럭 쌓기
		if (t == 1) {
			for (int i = 6; i <= 9; i++) {
				if (i == 9 && board[1][i][sy] == 0) {
					board[1][i][sy] = turn;
					break;
				}
				if (board[1][i][sy] != 0) {
					board[1][i - 1][sy] = turn;
					break;
				}
			}
		} else if (t == 3) {
			for (int i = 6; i <= 9; i++) {
				if (i == 9 && (board[1][i][sy] == 0 && board[1][i][sy + 1] == 0)) {
					board[1][i][sy] = turn;
					board[1][i][sy + 1] = turn;
					break;
				}
				if (board[1][i][sy] != 0 || board[1][i][sy + 1] != 0) {
					board[1][i - 1][sy] = turn;
					board[1][i - 1][sy + 1] = turn;
					break;
				}
			}
		} else {
			for (int i = 6; i <= 9; i++) {
				if (i == 9 && (board[1][i][sy] == 0)) {
					board[1][i][sy] = turn;
					board[1][i - 1][sy] = turn;
					break;
				}
				if (board[1][i][sy] != 0) {
					board[1][i - 1][sy] = turn;
					board[1][i - 2][sy] = turn;
					break;
				}
			}
		}

		for (int i = 6; i <= 9; i++) {
			int chk_cnt = 0;
			for (int j = 0; j < 4; j++) {
				if (board[1][i][j] != 0)
					chk_cnt++;
			}
			// 없애고 내리자
			if (chk_cnt == 4) {
				f_ans++;
				for (int x = i; x >= 4; x--) {
					for (int y = 0; y < 4; y++) {
						if (x == 4)
							board[1][x][y] = 0;
						else
							board[1][x][y] = board[1][x - 1][y];
					}
				}
			}
		}

		int del_cnt = 0;
		// 만약 4~5구간에 있을 때
		for (int i = 4; i <= 5; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[1][i][j] != 0) {
					del_cnt++;
					break;
				}
			}
		}

		if (del_cnt == 2) {
			for (int i = 9; i >= 6; i--) {
				for (int j = 0; j < 4; j++) {
					board[1][i][j] = board[1][i - 2][j];
				}
			}

			for (int i = 4; i <= 5; i++) {
				for (int j = 0; j < 4; j++) {
					board[1][i][j] = 0;
				}
			}
		} else if (del_cnt == 1) {
			for (int i = 9; i >= 6; i--) {
				for (int j = 0; j < 4; j++) {
					board[1][i][j] = board[1][i - 1][j];
				}
			}

			for (int j = 0; j < 4; j++) {
				board[1][5][j] = 0;
			}
		}
	}
}
