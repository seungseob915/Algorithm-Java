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

public class No10814{
	public static class Tuple{
		int x;
		String y;
		int order;
		
		public Tuple(int x, String y, int order) {
			this.x = x;
			this.y = y;
			this.order = order;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		Tuple [] arr=new Tuple[n];

		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			arr[i]=new Tuple(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		
		Arrays.sort(arr, new Comparator<Tuple>() {
			public int compare(Tuple p1, Tuple p2) {
				if(p1.x != p2.x)
					return p1.x-p2.x;
				else
					return p1.order - p2.order;
			}
			});
		
		for(Tuple p : arr) {
			bw.write(p.x+" "+p.y+"\n");
		}
		bw.flush();
		bw.close();
	}

}
