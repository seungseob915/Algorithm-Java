package kr.boj.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No15684 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, h;
	static int ret = -1;
	static boolean road[][];

	public static void main(String[] args) throws IOException {
		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		h = Integer.parseInt(str.nextToken());

		road = new boolean[h + 1][n + 1];
		
		for(int i=1; i<=m; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(temp.nextToken());
			int t2 = Integer.parseInt(temp.nextToken());
			road[t1][t2]=true;
		}
		
		dfs(0, 1);
		
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}

	private static void dfs(int depth, int height) {
		if(ret!=-1 && ret<depth) return;
		
		if(depth<=3) {
			if(check()) {
				ret=depth;
				return;
			}
		}
		else return;
		
		for(int i=height; i<=h; i++) {
			for(int j=1; j<n; j++) {
				if(road[i][j])	continue;
				if(j-1>0 && road[i][j-1]) continue;
				
				road[i][j]=true;
				dfs(depth+1, i);
				road[i][j]=false;
			}
		}
	}

	
	private static boolean check() {
		for(int i=1; i<=n; i++) {
			int now=i;
			for(int j=1; j<=h; j++) {
				if(road[j][now]) {
					now++;
				}
				else if(now-1>0 && road[j][now-1]) {
					now--;
				}
			}
			if(now!=i) return false; 
		}
		return true;
	}

}
