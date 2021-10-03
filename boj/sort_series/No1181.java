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
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringTokenizer;


public class No1181{

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		LinkedHashSet<String> str=new LinkedHashSet<String>();

		for(int i=0; i<n; i++) {
			str.add(br.readLine());
		}
		
		String[] s=(String[])str.toArray(new String[str.size()]);
		Arrays.sort(s, new Comparator<String>() {
				public int compare(String s1, String s2) {
					if(s1.length()!=s2.length())
						return s1.length()-s2.length();
					else {
						return s1.compareTo(s2);
					}
				}
		});
		
		for(String ss : s) {
			bw.write(ss+"\n");
		}
		bw.flush();
		bw.close();
	}

}
