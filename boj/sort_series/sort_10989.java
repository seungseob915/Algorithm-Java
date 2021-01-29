package kr.boj.sort_series;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class sort_10989 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[10001];
		
		for(int i=0; i<n; i++) {
			int now=Integer.parseInt(br.readLine());
			arr[now]++;
		}
		
		StringBuilder str=new StringBuilder();
		
		for(int i=1; i<10001; i++) {
			if(arr[i]==0) continue;
			while(arr[i]>0) {
				arr[i]--;
				str.append(i+"\n");
			}
		}
		bw.write(str.toString());
		bw.close();
	}

}
