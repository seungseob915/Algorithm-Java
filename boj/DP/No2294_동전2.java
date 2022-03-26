import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
       [BOJ] NO.2294  동전2

       ㅇ 점화식 : x금액의 동전의 최소 갯수 : Math.min(minCnt[x], minCnt[x - 해당 동전 Value] +1 )

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int coin[] = new int[N + 1];
        int minCnt[] = new int[K + 1];

        Arrays.fill(minCnt, Integer.MAX_VALUE - 1);

        for (int i = 1; i <= N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        minCnt[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = coin[i]; j <= K; j++) {
                minCnt[j] = Math.min(minCnt[j], minCnt[j - coin[i]] + 1);
            }
        }

        bw.write(String.valueOf(minCnt[K] == Integer.MAX_VALUE - 1 ? -1 : minCnt[K]));
        bw.flush();
        bw.close();
        br.close();
    }
}