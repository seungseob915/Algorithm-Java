package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No_14226 {
	static int input;
	static int time[][]=new int[1001][1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		input = Integer.parseInt(br.readLine());
		for(int i=0; i<1001; i++) Arrays.fill(time[i], -1);
		
		Queue<int[]> q=new LinkedList<int[]>();
		q.offer(new int[]{1, 0});
		time[1][0]=0;
		
		while(!q.isEmpty()) {
			int nows=q.peek()[0];
			int nowc=q.peek()[1];
			q.poll();
			
			// 클립보드 저장
			if(time[nows][nows]==-1) {
				time[nows][nows]=time[nows][nowc]+1;
				q.offer(new int[]{nows, nows});
			}
			// 클립보드 복사
			if(nows+nowc<=input && time[nows+nowc][nowc]==-1) {
				time[nows+nowc][nowc]=time[nows][nowc]+1;
				q.offer(new int[]{nows+nowc, nowc});
			}
			// 삭제
			if(nows-1>=0 && time[nows-1][nowc]==-1 ) {
				time[nows-1][nowc]=time[nows][nowc]+1;
				q.offer(new int[]{nows-1, nowc});
			}
			
		}
		
		int ans=987654321;
		for(int i=0; i<=input; i++) {
			if(time[input][i]!=-1)
				ans=Math.min(ans, time[input][i]);
		}
		
		System.out.println(ans);
	}

}
