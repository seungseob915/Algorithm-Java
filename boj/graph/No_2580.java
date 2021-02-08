package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Location {
	int x, y, box;

	public Location(int x, int y, int box) {
		this.x = x;
		this.y = y;
		this.box = box;
	}
}

public class No_2580 {

	static int board[][] = new int[9][9];
	static boolean check[][] = new boolean[10][10];
	static ArrayList<Location> al = new ArrayList<Location>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer stk1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(stk1.nextToken());
			}
		}

		int cnt = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int x = i * 3; x < i * 3 + 3; x++) {
					for (int y = j * 3; y < j * 3 + 3; y++) {
						if (board[x][y] != 0)
							check[cnt][board[x][y]] = true;
						else if (board[x][y] == 0)
							al.add(new Location(x, y, cnt));
					}
				}
				cnt++;
			}
		}
		dfs(0, al.size());
	}

	private static void dfs(int depth, int finish) {
		if (depth == finish) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(String.valueOf(board[i][j]) + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		for (int j = 1; j <= 9; j++) {

			if (check[al.get(depth).box][j])
				continue;
			if (!(posCheck(al.get(depth).x, al.get(depth).y, j)))
				continue;

			check[al.get(depth).box][j] = true;
			board[al.get(depth).x][al.get(depth).y] = j;

			dfs(depth + 1, finish);

			check[al.get(depth).box][j] = false;
			board[al.get(depth).x][al.get(depth).y] = 0;
		}

	}

	private static boolean posCheck(int x, int y, int n) {

		for (int i = 0; i < 9; i++) {
			if (board[i][y] == n)
				return false;
			if (board[x][i] == n)
				return false;
		}
		return true;
	}

}
