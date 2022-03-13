import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = 1;

		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(stk.nextToken());
			int P = Integer.parseInt(stk.nextToken());
			int V = Integer.parseInt(stk.nextToken());

			if (L == 0 && P == 0 && V == 0)
				break;

			int rem = (V % P) <= L ? (V % P) : L;
			int ret = (V / P) * L + rem;
			bw.write("Case " + (cnt++) + ": " + ret + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}