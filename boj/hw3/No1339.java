package kr.boj.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class No1339 {

	static int n;
	static int ret = -1;
	static boolean check[] = new boolean[10];
	static int hash[] = new int[26];
	static ArrayList<Integer> cnt = new ArrayList<Integer>();
	static ArrayList<Integer> order[];

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 대문자 A = 65 Z = 90
		n = Integer.parseInt(br.readLine());
		order = new ArrayList[n];
		for (int i = 0; i < n; i++)
			order[i] = new ArrayList<Integer>();

		Arrays.fill(hash, -2);

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				int cc=(int) c - 65;
				
				if (hash[cc] != -1) {
					hash[cc] = -1; // 존재하는 대문자는 -1로
					cnt.add(cc); // 문자의 종류 갯수
				}
				
				order[i].add(cc);
			}
		}

		dfs(0);

		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();

	}

	// Math.pow(a ,b) 메소드의 호출로 인해 시간초과 발생...
	private static void dfs(int depth) {
		if (depth == cnt.size()) {
			int t_sum = 0;

			for (int i = 0; i < n; i++) {
				int num=0;
				for (int j = 0; j < order[i].size(); j++) {
					num*=10;
					num+=hash[order[i].get(j)];
				}
				t_sum += num;
			}

			ret = Math.max(t_sum, ret);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if(check[i]) continue;
			
			int nowchar = cnt.get(depth);
			check[i]=true;
			hash[nowchar] = i;
			
			dfs(depth + 1);
			
			hash[nowchar] = -1;
			check[i]=false;
		}
	}
}