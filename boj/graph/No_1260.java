package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class No_1260 {
	static boolean visited[];
	static LinkedList<Integer> node[];
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String[] instr=br.readLine().split(" ");
		int totalnode=Integer.parseInt(instr[0]);
		
		// 각 정점별 간선 체크
		node=new LinkedList [totalnode+1];
		for(int i=1; i<=totalnode; i++) node[i]=new LinkedList();
		
		visited=new boolean[totalnode+1];
		
		for(int i=0; i<Integer.parseInt(instr[1]); i++) {
			String [] line=br.readLine().split(" ");
			node[Integer.parseInt(line[0])].add(Integer.parseInt(line[1]));
			node[Integer.parseInt(line[1])].add(Integer.parseInt(line[0]));
		}
		for(int i=1; i<=totalnode; i++)
			Collections.sort(node[i]);
		
		int start=Integer.parseInt(instr[2]);
		visited[start]=true;
		
		dfs(start);
		bw.newLine();
		Arrays.fill(visited, false);
		bfs(start);
		
		bw.close();
	}

	
	public static void dfs(int nownode) throws IOException {
			Iterator<Integer> it=node[nownode].listIterator();
			bw.write(String.valueOf(nownode)+" ");
			bw.flush();
			
			while(it.hasNext()) {
				int now=it.next();
				if(visited[now]) continue;
				visited[now]=true;
				dfs(now);
			}
	}
	
	private static void bfs(int start) throws IOException {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(start);
		visited[start]=true;

		while(!q.isEmpty()) {
			int now=q.peek();
			Iterator<Integer> it = node[now].listIterator(); 
			q.poll();
			bw.write(String.valueOf(now)+" ");

			while(it.hasNext()) {
				int b=it.next();
				if(visited[b]) continue;
				q.offer(b);
				visited[b]=true;
			}
		}
		bw.flush();
	}

}
