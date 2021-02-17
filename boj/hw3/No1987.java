package kr.boj.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char board[][];
	static int r, c, ret=-1;
	static Map<Character, Boolean> check = new HashMap<Character, Boolean>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		StringTokenizer input=new StringTokenizer(br.readLine());
		r=Integer.valueOf(input.nextToken());
		c=Integer.valueOf(input.nextToken());
		
		board=new char[r][c];
		
		for(int i=(int)'A'; i<=(int)'Z'; i++) {
			check.put((char)i, false);
		}
		
		for(int i=0; i<r; i++) {
			String str=br.readLine();
			for(int j=0; j<c; j++) {
				board[i][j]=str.charAt(j);
			}
		}
		
		check.put(board[0][0], true);
		dfs(1, 0, 0);
		
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}

	private static void dfs(int depth, int x, int y) {
		ret=Math.max(depth, ret);
		
		for(int k=0; k<4; k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			
			if(nx<0 || nx>r-1 || ny<0 || ny>c-1) continue;
			if(check.get(board[nx][ny])) continue;
			
			check.put(board[nx][ny], true);
			dfs(depth+1, nx, ny);
			check.put(board[nx][ny], false);
		}
		
	}

}
