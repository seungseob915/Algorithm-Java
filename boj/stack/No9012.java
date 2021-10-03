package kr.boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No9012{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<Character>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			stack.clear();
			
			for(int j=0; j<str.length(); j++) {
				if(!stack.empty() && stack.peek()=='(') {
					if(str.charAt(j)==')') {
						stack.pop();
						continue;
					}
				}
				stack.push(str.charAt(j));
			}
			if(!stack.empty())
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
	}

}
