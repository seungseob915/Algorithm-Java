package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class No_11724 {
	static boolean visited[];
	static LinkedList<Integer> node[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] input=br.readLine().split(" ");
		node=new LinkedList[Integer.parseInt(input[0])+1];
		visited=new boolean[Integer.parseInt(input[0])+1];
		
		for(int i=1; i<=Integer.parseInt(input[0]); i++) node[i]=new LinkedList<Integer>();
		
		for(int i=0; i<Integer.parseInt(input[1]); i++) {
			String[] str=br.readLine().split(" ");
			node[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
			node[Integer.parseInt(str[1])].add(Integer.parseInt(str[0]));
		}
		
		int cnt=0;
		
		for(int i=1; i<=Integer.parseInt(input[0]); i++) {
			if(visited[i]) continue;
			
			dfs(i);
			cnt++;
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int start) {
		Iterator<Integer> it= node[start].listIterator();
		
		while(it.hasNext()) {
			int next=it.next();
			if(visited[next]) continue;
			visited[next]=true;
			dfs(next);
		}
	}
}
