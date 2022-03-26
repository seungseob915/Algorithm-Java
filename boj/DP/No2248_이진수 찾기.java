import java.util.Arrays;
import java.util.Scanner;

/*
       [BOJ] NO.2248  이진수 찾기

       ㅇ N번째에 M개의 1을 갖는 케이스 : sum[n][m]=sum[n-1][m] (N번째가 0일경우) + sum[n-1][m-1] (N번째가 1일경우)
       ㅇ chkBinaryCase()에서 가능한 이진수 경우의 수를 모두 sum에 저장한 후, findAns() 에서 앞에서부터 "1", "0" 케이스를 통해 답을 좁혀나간다.


 */

public class Main {
    static long sum[][];
    static String ans = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        long I = sc.nextLong();

        sum = new long[N + 1][L + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(sum[i], -1);
        }

        int cnt = 0;

        for (int i = L; i >= 0; i--) {
            cnt += chkBinaryCase(N, i);
        }

        findAns(N, L, I);

        System.out.println(ans);
    }

    private static void findAns(int n, int l, long i) {
        if (n == 0) {
            return;
        }
        if (l == 0) {
            for (int x = 0; x < n; x++) {
                ans += "0";
            }
            return;
        }

        long skip = 0;

        // 현재 자리가 0인 경우, 다음 자리의 총 경우의 수의 합
        for(int x=0; x<=l; x++){
            if(sum[n-1][x]!=-1)
                skip+=sum[n-1][x];
        }

        if (skip >= i) {
            ans += "0";
            findAns(n - 1, l, i);
        } else {
            ans += "1";
            findAns(n - 1, l - 1, i - skip);
        }

        return;
    }

    private static long chkBinaryCase(int n, int l) {
        if (l < 0) {
            return 0;
        }
        if (n < l) {
            return sum[n][l] = 0;
        }
        if (sum[n][l] != -1) {
            return sum[n][l];
        }
        if (n == 0 || l == 0) {
            return sum[n][l] = 1;
        }

        return sum[n][l] = chkBinaryCase(n - 1, l) + chkBinaryCase(n - 1, l - 1);
    }

}

