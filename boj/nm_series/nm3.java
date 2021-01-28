package kr.boj.nm_series;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class nm3 {
	static int n, m;
	static int arr[]=new int[8];
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int depth) throws IOException {
		if(depth==m) {
			String str="";
			for(int i=0; i<m; i++) {
				str=String.valueOf(arr[i])+" ";
				bw.write(str);
			}
			bw.newLine();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			arr[depth]=i;
			dfs(depth+1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		
		dfs(0);
		bw.flush();
		bw.close();
	}

}
