package kr.boj.nm_series;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class nm4 {
	static int n, m;
	static int arr[]=new int[9];
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int start, int depth) throws IOException {
		if(depth==m) {
			String str="";
			for(int i=0; i<m; i++) {
				str=String.valueOf(arr[i])+" ";
				bw.write(str);
			}
			bw.newLine();
			return;
		}
		
		for(int i=start; i<=n; i++) {
			arr[depth]=i;
			dfs(i, depth+1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		
		dfs(1, 0);
		bw.flush();
		bw.close();
	}

}
