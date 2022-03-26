import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
       [BOJ] NO.11055  가장 큰 증가 부분 수열

       ㅇ DP : Idx 앞부터 시작해서, 체크해 나간다.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        int sum[] = new int[N];

        for (int i = 0; i < N; i++) {
            sum[i] = A[i];
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && sum[i] < sum[j] + A[i]) {
                    sum[i] = sum[j] + A[i];
                }
            }
        }

        Arrays.sort(sum);

        bw.write(String.valueOf(sum[N - 1]));
        bw.flush();
        bw.close();
        br.close();
    }
}