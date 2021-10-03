package kr.boj.sort_series;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class No2108{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[8002];
		int total=0;
		int mid=987654321;
		int most_cnt=0;
		int most_no=987654321;
		int max=-987654321;
		int min=987654321;
		
		for(int i=0; i<n; i++) {
			int now=Integer.parseInt(br.readLine());
			total+=now;
			if(now<0) now=4001+now;
			else if(now>0) now=4001+now;
			else now=4001;
			arr[now]++;
		}
		
		int cnt=0;
		int b_cnt=0;
		boolean mid_find=false;
		
		for(int i=1; i<8002; i++) {
			if(arr[i]==0) continue;
			cnt+=arr[i];
			
			if(cnt==(n/2+1) || (cnt>(n/2+1) && mid_find==false)) {
				mid=i-4001;
				mid_find=true;
			}
			if(most_cnt<=arr[i]) {
				if(most_cnt==arr[i] && b_cnt<2) {
					most_cnt=arr[i];
					most_no=i;
					b_cnt++;
				}
				else if(most_cnt!=arr[i]) {
					most_cnt=arr[i];
					most_no=i;
					b_cnt=1;
				}
			}
			if(max<i) max=i;
			if(min>i) min=i;
		}
		System.out.println(Math.round((double)total/n));
		System.out.println(mid);
		System.out.println(most_no-4001);
		System.out.println(max-min);
	}

}
