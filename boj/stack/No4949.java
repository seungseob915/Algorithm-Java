package kr.boj.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No4949{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<String>();

		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;

			stack.clear();
			String sarr[] = str.split("");
			boolean finish = false;

			for (String s : sarr) {
				if (s.equals("(") || s.equals("[")) {
					stack.push(s);
				} else if (s.equals(")")) {
					if ((!stack.empty()) && (stack.peek().equals("("))) {
						stack.pop();
					} else {
						finish = true;
						break;
					}
				} else if (s.equals("]")) {
					if ((!stack.empty()) && (stack.peek().equals("["))) {
						stack.pop();
					} else {
						finish = true;
						break;
					}
				}

			}
			if (finish)
				System.out.println("no");
			else {
				if (stack.empty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}
}
