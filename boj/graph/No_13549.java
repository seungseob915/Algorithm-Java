package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_13549 {
	static int[] board = new int[100001];
	static int start = 0;
	static int end = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str, " ");

		start = Integer.parseInt(stk.nextToken());
		end = Integer.parseInt(stk.nextToken());
		Arrays.fill(board, -1);

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		board[start] = 0;

		while (!q.isEmpty()) {
			int now = q.peek();
			q.poll();

			if (now * 2 <= 100000) {
				if (board[2 * now] == -1 || board[2 * now] > board[now]) {
					board[2 * now] = board[now];
					q.offer(2 * now);
				}
			}
			if (now + 1 <= 100000) {
				if (board[now + 1] == -1 || board[now + 1] > board[now]) {
					board[now + 1] = board[now] + 1;
					q.offer(now + 1);
				}
			}
			if (now - 1 >= 0) {
				if (board[now - 1] == -1 || board[now - 1] > board[now]) {
					board[now - 1] = board[now] + 1;
					q.offer(now - 1);
				}
			}
		}

		bw.write(String.valueOf(board[end]));
		bw.flush();
		bw.close();

	}

}
