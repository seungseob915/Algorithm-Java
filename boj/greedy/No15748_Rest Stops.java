import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Hiking implements Comparable<Hiking> {
		private int x, c;

		public Hiking(int x, int c) {
			this.x = x;
			this.c = c;
		}

		public int getX() {
			return x;
		}

		public int getC() {
			return c;
		}

		@Override
		public int compareTo(Hiking o) {
			if(this.getC() == o.getC()){
				return (this.getX() - o.getX()) * -1;
			}
			else{
				return (this.getC() - o.getC()) * -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		int rf = Integer.parseInt(stk.nextToken());
		int rb = Integer.parseInt(stk.nextToken());

		PriorityQueue<Hiking> pq=new PriorityQueue<>();

		for(int i=0; i<N; i++){
			stk=new StringTokenizer(br.readLine());

			int x=Integer.parseInt(stk.nextToken());
			int c=Integer.parseInt(stk.nextToken());

			pq.add(new Hiking(x, c));
		}

		int nowIdx=0;
		int timeGap=rf-rb;
		long answer=0;

		while(!pq.isEmpty()){
			Hiking now=pq.poll();

			if(now.getX()<=nowIdx)
				continue;

			answer+= (long) now.getC() * (now.getX() - nowIdx) * timeGap;
			nowIdx=now.getX();
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}