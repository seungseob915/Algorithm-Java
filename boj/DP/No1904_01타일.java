import java.io.*;

/*
       [BOJ] NO.1904  01타일

       ㅇ N=1 ~ 6까지 계산 한 결과, 피보나치 수열의 패턴.
       ㅇ DP를 활용한 피보나치 수열 구현

 */

public class Main {

    static int chk[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = solution(N);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(int n) {
        if (chk[n] != 0) {
            return chk[n];
        }
        if (n == 1) {
            return chk[n] = 1;
        }
        if (n == 2) {
            return chk[n] = 2;
        }
        return chk[n] = (solution(n - 1)  + solution(n - 2)) % 15746;
    }
}