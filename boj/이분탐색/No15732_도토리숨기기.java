import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Rule {
        int a, b, c;

        public Rule(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int N, K, D;
    static Rule rules[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());

        rules = new Rule[K + 1];

        int lo = 1;
        int hi = 1;

        for (int i = 1; i <= K; i++) {
            stk = new StringTokenizer(br.readLine());

            int ta = Integer.parseInt(stk.nextToken());
            int tb = Integer.parseInt(stk.nextToken());
            int tc = Integer.parseInt(stk.nextToken());

            rules[i] = new Rule(ta, tb, tc);
            hi = Math.max(hi, tb);
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // 더 낮아져도 될 때
            if (checkLastBox(mid)) {
                hi = mid - 1;
            }
            // 더 높아야할 때
            else {
                lo = mid + 1;
            }
        }

        bw.write(String.valueOf(lo));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkLastBox(int lastIdx) {
        long dCnt = 0;

        for (int i = 1; i <= K; i++) {
            if (rules[i].a > lastIdx)
                continue;

            int tHiIdx = Math.min(lastIdx, rules[i].b);
            dCnt += (tHiIdx - rules[i].a) / rules[i].c + 1;

        }

        if (dCnt < D)
            return false;

        return true;
    }
}
