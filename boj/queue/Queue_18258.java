package kr.boj.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Queue_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		Deque <Integer> queue=new LinkedList<Integer>();
		
		int n=Integer.parseInt(br.readLine());
		String[] stk;
		
		while(n>0) {
			String str=br.readLine();
			stk=str.split(" ");

			if(stk[0].equals("push"))
				queue.offer(Integer.parseInt(stk[1]));
			else if(stk[0].equals("pop")){
				if(!queue.isEmpty()) {
					bw.write(String.valueOf(queue.peek())+"\n");
					queue.poll();
				}
				else {
					bw.write("-1\n");
				}
			}
			else if(stk[0].equals("front")) {
				if(!queue.isEmpty()) {
					bw.write(String.valueOf(queue.peek())+"\n");
				}
				else {
					bw.write("-1\n");
				}
			}
			else if(stk[0].equals("back")) {
				if(!queue.isEmpty()) {
					bw.write(String.valueOf(queue.peekLast())+"\n");
				}
				else {
					bw.write("-1\n");
				}
			}
			else if(stk[0].equals("size")) {
				bw.write(String.valueOf(queue.size())+"\n");
			}
			else if(stk[0].equals("empty")) {
				if(queue.isEmpty()) {
					bw.write("1\n");
				}
				else {
					bw.write("0\n");
				}
			}
			n--;
		}
		bw.flush();
		bw.close();
	}

}
