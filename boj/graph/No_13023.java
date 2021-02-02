package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No_13023 {
	static boolean visited[];
	static ArrayList<Integer> node[];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		visited = new boolean[n];
		node = new ArrayList[n];

		for (int i = 0; i < n; i++)
			node[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			String temp[] = br.readLine().split(" ");
			int n1 = Integer.parseInt(temp[0]);
			int n2 = Integer.parseInt(temp[1]);

			node[n1].add(n2);
			node[n2].add(n1);
		}


		for (int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
			if(ans==1) break;
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();

	}

	private static void dfs(int n, int depth) {
		if(depth==5) {
			ans=1;
			return;
		}
		for (int i = 0; i < node[n].size(); i++) {
			int next = node[n].get(i);
			if (visited[next])
				continue;
			visited[next] = true;
			dfs(next, depth+1);
			visited[next]= false;
		}
	}

}
