package kr.boj.nm_series;

import java.util.Scanner;

public class nm2 {
	static int n, m;
	static int arr[]=new int[9];
	static boolean chk[]=new boolean[9];
	
	public static void dfs(int now, int depth) {
		if(depth==m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=now+1; i<=n; i++) {
			if(chk[i]) continue;
			chk[i]=true;
			arr[depth]=i;
			dfs(i, depth+1);
			chk[i]=false;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		
		dfs(0, 0);
	}

}
