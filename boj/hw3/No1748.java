package kr.boj.hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1748 {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		int cnt=1;
		int length=10;
		int ans=0;
		
		for(int i=1; i<=n; i++) {
			if(length==i) {
				length*=10;
				cnt++;
			}
			ans+=cnt;
			
//			int temp=1;
			
//			if(i<10) temp=1;
//			else if(i<100) temp=2;
//			else if(i<1000) temp=3;
//			else if(i<10000) temp=4;
//			else if(i<100000) temp=5;
//			else if(i<1000000) temp=6;
//			else if(i<10000000) temp=7;
//			else if(i<100000000) temp=8;
//			else temp=9;
//				cnt+=temp;
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
