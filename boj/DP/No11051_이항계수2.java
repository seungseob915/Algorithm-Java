import java.io.*;
import java.util.StringTokenizer;

/*
       [BOJ] NO.11051  이항계수2

       ㅇ 점화식 : nCr = n-1Cr-1 + n-1Cr
       ㅇ 계산 중복이 발생하므로, 메모이제이션을 활용한 DP 풀이

 */

public class Main {
    static int dp[][] = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        int answer = bino(N, K);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bino(int n, int k) {
        if (dp[n][k] != 0) {
            return dp[n][k];
        }

        return dp[n][k] = (bino(n - 1, k - 1) % 10007 + bino(n - 1, k) % 10007) % 10007;
    }
}