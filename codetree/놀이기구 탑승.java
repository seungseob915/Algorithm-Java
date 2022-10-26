
/*
       [CodeTree] 놀이기구 탑승 - '22.10.26

 */

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] relation;
	static Map relOrder;
	static int[][] board;
	static int[][] blankMap;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];
		blankMap = new int[N + 1][N + 1];

		relation = new int[N * N + 1][5];
		relOrder = new HashMap<Integer, Integer>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if ((i == 1 && j == 1) || (i == 1 && j == N) || (i == N && j == 1) || (i == N && j == N)) {
					blankMap[i][j] = 2;
					continue;
				}
				if (i == 1 || j == 1 || i == N || j == N) {
					blankMap[i][j] = 3;
					continue;
				}
				blankMap[i][j] = 4;
			}
		}

		for (int i = 1; i <= N * N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			for (int j = 0; j <= 4; j++) {
				relation[i][j] = Integer.parseInt(stk.nextToken());

				if (j == 0) {
					relOrder.put(relation[i][j], i);
				}
			}
		}

		for (int k = 1; k <= N * N; k++) {
			moveStudent(k);
		}

		int totalScore = 0;

		// 최종 친구 탐색
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int nStudent = board[i][j];
				int nStudentArrIdx = (int) relOrder.get(nStudent);
				int nCnt = 0;

				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 1 || nx > N || ny < 1 || ny > N)
						continue;

					if(board[nx][ny] == relation[nStudentArrIdx][1]) nCnt++;
					if(board[nx][ny] == relation[nStudentArrIdx][2]) nCnt++;
					if(board[nx][ny] == relation[nStudentArrIdx][3]) nCnt++;
					if(board[nx][ny] == relation[nStudentArrIdx][4]) nCnt++;
				}

				if(nCnt==1) totalScore+=1;
				if(nCnt==2) totalScore+=10;
				if(nCnt==3) totalScore+=100;
				if(nCnt==4) totalScore+=1000;
			}
		}

		System.out.println(totalScore);
	}

	private static void moveStudent(int num) {
		int posX = -1;
		int posY = -1;
		int nearByFriendCnt = -1;
		int blankCnt = -1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (board[i][j] != 0) {
					continue;
				}

				int tmpNearByFriendCnt = chkNearByFriend(num, i, j);

				// 1. 인접 친구 갯수 체크
				// 1-1. 인접 친구 갯수가 클 때
				if (tmpNearByFriendCnt > nearByFriendCnt) {
					posX = i;
					posY = j;
					nearByFriendCnt = tmpNearByFriendCnt;
					blankCnt = blankMap[i][j];
				}
				// 1-2. 인접 친구 갯수가 같을 때
				else if (tmpNearByFriendCnt == nearByFriendCnt) {
					// 2-1. Blank가  더 많을 때
					if (blankMap[i][j] > blankCnt) {
						posX = i;
						posY = j;
						blankCnt = blankMap[i][j];
					}
					// 2-2. Blank가 같거나 작을 때 => continue
					else {
					}
				}
				// 1-3. 인접 친구 갯수가 적을 때 => continue
				else {
				}
			}
		}

		// 최종 배치
		board[posX][posY] = relation[num][0];
		blankMap[posX][posY] = 0;
		for (int d = 0; d < 4; d++) {
			int nx = posX + dx[d];
			int ny = posY + dy[d];
			if (nx < 1 || nx > N || ny < 1 || ny > N)
				continue;

			blankMap[nx][ny]--;
		}
	}

	private static int chkNearByFriend(int num, int posX, int posY) {
		int x = posX;
		int y = posY;
		int ret = 0;

		for (int d = 0; d < 4; d++) {
			int nx = posX + dx[d];
			int ny = posY + dy[d];

			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				continue;
			}

			if (board[nx][ny] == 0)
				continue;

			for (int k = 1; k <= 4; k++) {
				if (board[nx][ny] == relation[num][k]) {
					ret++;
				}
			}
		}

		return ret;
	}
}

