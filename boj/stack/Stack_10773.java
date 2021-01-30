package kr.boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Stack_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		Stack <Integer> stack=new Stack<Integer>();
		
		int n=Integer.parseInt(br.readLine());
		String[] stk;
		
		while(n>0) {
			String str=br.readLine();
			stk=str.split(" ");
			
			if(stk[0].equals("push"))
				stack.push(Integer.parseInt(stk[1]));
			else if(stk[0].equals("pop")){
				if(!stack.empty()) {
					System.out.println(stack.peek());
					stack.pop();
				}
				else 
					System.out.println(-1);
			}
			else if(stk[0].equals("top")) {
				if(!stack.empty())
					System.out.println(stack.peek());
				else
					System.out.println(-1);
			}
			else if(stk[0].equals("size")) {
				System.out.println(stack.size());
			}
			else if(stk[0].equals("empty")) {
				if(stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			n--;
		}
		
	}

}
