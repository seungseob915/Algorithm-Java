package kr.boj.sort_series;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class sort_2750 {
	
	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=scan.nextInt();
		int arr[]=new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=scan.nextInt();
		}
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
