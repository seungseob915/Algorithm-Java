package kakao2021;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Card {
	int x;
	int y;
	boolean picked = false;

	public Card() {
	}

	public Card(int x, int y, boolean picked) {
		this.x = x;
		this.y = y;
		this.picked = picked;
	}
}

class Go {
	int x;
	int y;
	int dist;

	public Go() {
	}

	public Go(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class 카드_짝_맞추기 {

	static Map<Integer, ArrayList<Card>> card = new HashMap<Integer, ArrayList<Card>>();
	static boolean[] c_visit;
	static int[][] tboard;
	static int ans = 987654321;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] board = { { 3, 0, 0, 2 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 2, 0, 0, 3 } };
		int r = 0, c = 1;

		tboard = board;

		// 뭐부터 없앨건지 조합부터 하자
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] == 0)
					continue;

				if (card.containsKey(board[i][j])) {
					ArrayList<Card> temp = card.get(board[i][j]);
					temp.add(new Card(i, j, false));
					card.put(board[i][j], temp);
				} else {
					ArrayList<Card> temp = new ArrayList<Card>();
					temp.add(new Card(i, j, false));
					card.put(board[i][j], temp);
				}
			}
		}

		c_visit = new boolean[card.size() + 1];

		dfs(0, 0, card.size(), new Point(r, c));
		ans += (card.size() * 2);
		System.out.println(ans);
	}

	private static void dfs(int sum, int depth, int finish, Point now) {
		if (depth == finish) {
			ans = Math.min(ans, sum);
		}

		if (ans < sum)
			return;

		for (int i = 1; i <= finish; i++) {
			if (c_visit[i])
				continue;

			for (int j = 0; j < 2; j++) {
				// 거리를 계산해서 넘겨주고 초과하면 더이상 가지 않도록 가지치기 하자
				int[] t_cnt = min_route(now, i, j); // 현재 위치, 이번 없앨 카드 번호, 먼저 없앨 카드 순서(0 or 1)

				c_visit[i] = true;
				tboard[card.get(i).get(0).x][card.get(i).get(0).y] = 0;
				tboard[card.get(i).get(1).x][card.get(i).get(1).y] = 0;

				dfs(sum + t_cnt[2], depth + 1, finish, new Point(t_cnt[0], t_cnt[1]));

				tboard[card.get(i).get(0).x][card.get(i).get(0).y] = i;
				tboard[card.get(i).get(1).x][card.get(i).get(1).y] = i;
				c_visit[i] = false;
			}
		}
	}

	private static int[] min_route(Point first, int card_no, int card_ord) {
		if (card_ord == 0) {
			int[] f_zero = bfs(first, card_no, 0);
			int[] s_one = bfs(new Point(f_zero[0], f_zero[1]), card_no, 1);
			int min_cnt1 = f_zero[2] + s_one[2];
			return new int[] { s_one[0], s_one[1], min_cnt1 };
		}

		else {
			int[] f_one = bfs(first, card_no, 1);
			int[] s_zero = bfs(new Point(f_one[0], f_one[1]), card_no, 0);
			int min_cnt2 = f_one[2] + s_zero[2];
			return new int[] { s_zero[0], s_zero[1], min_cnt2 };
		}
	}

	private static int[] bfs(Point first, int card_no, int card_ord) {
		int checked[][] = new int[4][4];
		int min_cnt = 0;
		int now_x = first.x;
		int now_y = first.y;

		// 순서는 여기서 0 -> 1 or 1 -> 0 중 최소인 것으로 선택해서 return해주자

		if (!(first.x == card.get(card_no).get(card_ord).x && first.y == card.get(card_no).get(card_ord).y)) {
			for (int i = 0; i < 4; i++)
				Arrays.fill(checked[i], -1);

			PriorityQueue<Go> pq = new PriorityQueue<Go>(new Comparator<Go>() {
				@Override
				public int compare(Go g1, Go g2) {
					return g1.dist >= g2.dist ? 1 : -1;
				}
			});

			pq.add(new Go(first.x, first.y, 0));
			checked[first.x][first.y] = 0;
			boolean finish = false;

			while (!pq.isEmpty()) {
				Go now = pq.poll();

				for (int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];

					if (nx > 3 || nx < 0 || ny > 3 || ny < 0)
						continue;
					if (checked[nx][ny] != -1)
						continue;
					if (nx == card.get(card_no).get(card_ord).x && ny == card.get(card_no).get(card_ord).y) {
						now_x = nx;
						now_y = ny;
						min_cnt = checked[now.x][now.y] + 1;
						finish = true;
						break;
					}
					if (finish)
						break;

					pq.add(new Go(nx, ny, now.dist + 1));
					checked[nx][ny] = checked[now.x][now.y] + 1;
				}

				for (int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];

					while ((nx < 4 && nx >= 0 && ny < 4 && ny >= 0) && tboard[nx][ny] == 0) {
						nx += dx[d];
						ny += dy[d];
					}
					if (nx > 3 || nx < 0 || ny > 3 || ny < 0) {
						nx -= dx[d];
						ny -= dy[d];
					}
					if (checked[nx][ny] != -1)
						continue;
					if (nx == card.get(card_no).get(card_ord).x && ny == card.get(card_no).get(card_ord).y) {
						now_x = nx;
						now_y = ny;
						min_cnt = checked[now.x][now.y] + 1;
						finish = true;
						break;
					}
					if (finish)
						break;
					pq.add(new Go(nx, ny, now.dist + 1));
					checked[nx][ny] = checked[now.x][now.y] + 1;
				}
				if (finish)
					break;
			}
		}

		return new int[] { now_x, now_y, min_cnt };
	}

}
