import java.io.*;
import java.util.*;

public class Main {

	static int cache[][] = new int[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String P = br.readLine();
		int N = Integer.parseInt(br.readLine());

		String[] dir = new String[N];

		for (int i = 0; i < N; i++) {
			dir[i] = br.readLine();
			if (match(0, 0, P, dir[i]) == 1) {
				bw.write(dir[i] + "\n");
			}

			for (int j = 0; j < 101; j++) {
				Arrays.fill(cache[j], 0);
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static int match(int pIdx, int sIdx, String p, String s) {
		int ret = cache[pIdx][sIdx];

		if (ret != 0) {
			return ret;
		}

		while (sIdx < s.length() && pIdx < p.length() && (p.charAt(pIdx) == s.charAt(sIdx))) {
			return cache[pIdx][sIdx] = match(pIdx + 1, sIdx + 1, p, s);
		}

		if (pIdx == p.length())
			return cache[pIdx][sIdx] = (sIdx == s.length() ? 1 : -1);

		if (p.charAt(pIdx) == '*') {
			if (match(pIdx + 1, sIdx, p, s) == 1 || (sIdx < s.length() && match(pIdx, sIdx + 1, p, s) == 1))
				return cache[pIdx][sIdx] = 1;
		}
		return cache[pIdx][sIdx] = -1;
	}
}