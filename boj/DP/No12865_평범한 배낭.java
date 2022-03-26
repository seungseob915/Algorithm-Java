import java.io.*;
import java.util.StringTokenizer;

/*
       [BOJ] NO.12865  평범한 배낭

       ㅇ DP에서 자주 등장하는 배낭 채우기(Knapsack) 문제

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int dp[][] = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            for (int j = 1; j <= K; j++) {
                dp[i][j] = (j - w >= 0 ? Math.max(dp[i - 1][j], dp[i - 1][j - w] + v) : dp[i - 1][j]);
            }
        }

        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}