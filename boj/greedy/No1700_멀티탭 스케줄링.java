import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		int order[] = new int[K];
		Set<Integer> multitap = new HashSet<>();

		stk = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(stk.nextToken());
		}

		int answer = 0;

		for (int i = 0; i < K; i++) {
			int now = order[i];

			if (multitap.contains(now)) {
				continue;
			}
			if (multitap.size() < N) {
				multitap.add(now);
				continue;
			}

			int maxDist = 0;
			int maxValue = 0;


			Outer:
			for (int it : multitap) {
				boolean noReuse = true;
				for (int x = i + 1; x < K; x++) {
					if (it == order[x]) {
						noReuse = false;
						if (maxDist < x - i) {
							maxDist = x - i;
							maxValue = it;
						}
						break;
					}
				}

				if (noReuse) {
					maxValue = it;
					break Outer;
				}
			}

			multitap.remove(maxValue);
			multitap.add(now);
			answer++;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}