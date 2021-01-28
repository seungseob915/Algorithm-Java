package kr.boj.nm_series;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class nm12 {
	static int n, m;
	static int arr[];
	static boolean chk[]=new boolean[9];
	static int ret[]=new int[9];
	static LinkedHashSet<String> lhs=new LinkedHashSet<>();
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int start, int depth) throws IOException {
		if(depth==m) {
			String str="";
			for(int i=0; i<m; i++) {
				str+=(ret[i]+" ");
			}
			lhs.add(str);
			return;
		}
	
		for(int i=start; i<n; i++) {
			ret[depth]=arr[i];
			dfs(i, depth+1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		
		arr=new int[n];
		
		for(int i=0; i<n; i++) arr[i]=scan.nextInt();
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		Iterator<String> it=lhs.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
