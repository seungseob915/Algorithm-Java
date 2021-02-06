package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_2529 {
	static int input;
	static long max_ans=-1;
	static long min_ans;
	static String max_str="";
	static String min_str="";
	static boolean check[];
	static char budeungho[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		input=Integer.parseInt(br.readLine());
		check=new boolean[10];
		budeungho=new char[input];
	
		
		String str[]=br.readLine().split(" ");

		for(int i=0; i<input; i++) {
			budeungho[i]=str[i].charAt(0);
		}
		
		for(int i=0; i<=9; i++) {
			check[i]=true;
			dfs(0, String.valueOf(i), i);
			check[i]=false;
		}
		bw.write(max_str+"\n"+min_str);
		bw.flush();
		bw.close();
	}

	private static void dfs(int depth, String s, int last) {
		if(depth==input) {
			long val=Long.parseLong(s);
			
			if(max_ans<val) {
				max_ans=val;
				max_str=s;
			}
			if(min_ans>val) {
				min_ans=val;
				min_str=s;
			}
			return;
		}
		
		for(int next=0; next<=9; next++) {
			if(check[next]) continue;
			if(budeungho[depth]=='>' && last<next)	continue;
			if(budeungho[depth]=='<' && last>next)	continue;
			
			check[next]=true;
			dfs(depth+1, s+String.valueOf(next), next);
			check[next]=false;
		}
	}

}
