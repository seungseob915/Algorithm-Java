import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Problem implements Comparable<Problem> {
		private int d;
		private int v;

		public Problem(int d, int v) {
			this.d = d;
			this.v = v;
		}

		public int getD() {
			return d;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.d > o.d) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int incorrCnt = 0;
		Problem problem[] = new Problem[11];

		for (int i = 0; i < 11; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(stk.nextToken());
			int V = Integer.parseInt(stk.nextToken());
			incorrCnt += V;

			problem[i] = new Problem(D, V);
		}

		Arrays.sort(problem);

		int nTime = 0;
		int ret = incorrCnt * 20;

		for (int i = 0; i < 11; i++) {
			nTime += problem[i].getD();
			ret += nTime;
		}

		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}