package kr.boj.sort_series;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class sort_11650 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		Pair [] arr=new Pair[n];

		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			arr[i]=new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				if(p1.x != p2.x)
					return p1.x-p2.x;
				else
					return p1.y-p2.y;
			}
			});
		
		for(Pair p : arr) {
			bw.write(p.x+" "+p.y+"\n");
		}
		bw.flush();
		bw.close();
	}

}
