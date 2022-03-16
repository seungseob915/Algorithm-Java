import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Gap implements Comparable<Gap> {
		private int left, right, gap;

		public Gap(int left, int right, int gap) {
			this.left = left;
			this.right = right;
			this.gap = gap;
		}

		public int getGap() {
			return gap;
		}

		@Override
		public int compareTo(Gap o) {
			if (this.gap == o.gap)
				return this.left - o.left;
			else
				return (this.gap - o.gap) * -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		if(K>=N){
			bw.write("0");
			bw.flush();
			bw.close();
			br.close();

			return;
		}
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int board[] = new int[N];

		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(board);
		PriorityQueue<Gap> pq = new PriorityQueue<>();

		int ret=0;

		for (int i = 1; i < N; i++) {
			int gap=board[i] - board[i - 1];
			ret+=gap;
			pq.add(new Gap(i - 1, i, gap));
		}

		for (int i = 0; i < K-1; i++) {
			ret-=pq.poll().getGap();
		}

		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}