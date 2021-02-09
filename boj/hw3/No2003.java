package kr.boj.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2003 {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(stk.nextToken());
		long m=Integer.parseInt(stk.nextToken());
		
		int a[]=new int[n];
		
		StringTokenizer stk2=new StringTokenizer(br.readLine(), " ");
		int idx=0;
		
		while(stk2.hasMoreTokens()) {
			a[idx++]=Integer.parseInt(stk2.nextToken());
		}
		
		int ret=0;
		int sum=0;
		int start=0;
		int end=0;
		
		// 투포인터
		while(true) {
			if(sum>=m) sum-=a[start++];
			else if(end==n) break;
			else if(sum<m) sum+=a[end++];
			if(sum==m) ret++;
		}
		
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}
}
