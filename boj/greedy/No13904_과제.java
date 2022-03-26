import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Homework {
		private int d, w;

		public int getD() {
			return d;
		}

		public int getW() {
			return w;
		}

		public Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Homework> pq = new PriorityQueue<>(new Comparator<Homework>() {
			@Override
			public int compare(Homework o1, Homework o2) {
				return o2.getW() - o1.getW();
			}
		});

		int maxDay = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());

			maxDay = Math.max(maxDay, d);
			pq.add(new Homework(d, w));
		}

		boolean chk[] = new boolean[maxDay+1];
		int answer = 0;

		while (!pq.isEmpty()) {
			Homework now = pq.poll();

			if(chk[now.getD()]){
				int findPoint=now.getD();
				while(true){
					findPoint--;

					if(findPoint==0){
						break;
					}

					if(chk[findPoint])
						continue;

					chk[findPoint]=true;
					answer+=now.getW();
					break;
				}
			}

			else{
				chk[now.getD()]=true;
				answer+=now.getW();
			}

		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}