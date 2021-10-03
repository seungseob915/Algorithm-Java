package kr.boj.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class No11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		// 우선순위가 낮은 숫자 순
		//PriorityQueue <Integer> queue=new PriorityQueue<Integer>();
		// 우선순위가 높은 숫자 순
		PriorityQueue <Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());
		
		/*	임의의 comparator 생성
		 * PriorityQueue<Student> reversedPriorityQueue = new
		 * PriorityQueue<>(priorityQueue.size(), new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student p1, Student p2) { return p1.age >=
		 * p2.age ? 1 : -1; } });
		 */
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int x=Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(queue.isEmpty()) 
					bw.write("0\n");
				else
					bw.write(String.valueOf(queue.poll())+"\n");
				
				continue;
			}
			
			queue.offer(x);
		}
		
		bw.flush();
		bw.close();
	}
}
