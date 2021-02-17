package kr.boj.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1062 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, k;
	static String str[];
	static boolean chk[] = new boolean[26];
	static ArrayList<Integer> al=new ArrayList<Integer>();
	static int ret = -1;

	public static void main(String[] args) throws IOException {
		StringTokenizer stk=new StringTokenizer(br.readLine());
		n=Integer.parseInt(stk.nextToken());
		k=Integer.parseInt(stk.nextToken());
		
		str=new String[n];
		
		if(k>=5) {
			chk[0]=true;
			chk[2]=true;
			chk[(int)'n'-(int)'a']=true;
			chk[(int)'t'-(int)'a']=true;
			chk[(int)'i'-(int)'a']=true;
			
			for(int i=0; i<n; i++) {
				String temp=br.readLine();
				str[i]=temp.substring(4, temp.length()-4);
			}
			dfs(0, 0);
		}
		
		bw.write(String.valueOf(ret == -1 ? 0 : ret));
		bw.flush();
		bw.close();
	}

	private static void dfs(int depth, int s) {
		if(ret==n) return;
		if(depth==k-5) {
			int cnt=0;
			for(int i=0; i<n; i++) {
				boolean check=true;
				for(int j=0; j<str[i].length(); j++) {
					if(chk[(int)str[i].charAt(j)-(int)'a']) continue;
					check=false;
					break;
				}
				if(check) cnt++;
			}
			ret=Math.max(ret, cnt);
			return;
		}
		
		for(int now=s; now<26; now++) {
			if(chk[now]) continue;
			chk[now]=true;
			dfs(depth+1, now+1);
			chk[now]=false;
		}
		
	}

}
