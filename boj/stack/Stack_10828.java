package kr.boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Stack_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		Stack <Integer> stack=new Stack<Integer>();
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int t=Integer.parseInt(br.readLine());
			if(t==0)
				stack.pop();
			else
				stack.push(t);
		}
		
		int ret=0;
		while(!stack.empty()) {
			ret+=stack.pop();
		}
		System.out.println(ret);
	}

}
