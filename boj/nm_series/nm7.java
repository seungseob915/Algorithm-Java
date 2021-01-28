package kr.boj.nm_series;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class nm7 {
	static int n, m;
	static int arr[];
	static int ret[]=new int[9];
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int depth) throws IOException {
		if(depth==m) {
			String str="";
			for(int i=0; i<m; i++) {
				str=String.valueOf(ret[i])+" ";
				bw.write(str);
			}
			bw.newLine();
			return;
		}
		
		for(int i=0; i<n; i++) {
			ret[depth]=arr[i];
			dfs(depth+1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		
		arr=new int[n];
		
		for(int i=0; i<n; i++) arr[i]=scan.nextInt();
		
		Arrays.sort(arr);
		
		dfs(0);
		
		bw.flush();
		bw.close();
	}

}
