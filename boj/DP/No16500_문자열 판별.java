import java.io.*;
import java.util.Arrays;

/*
       [BOJ] NO.16500  문자열 판별

       ㅇ DP : 문자열 S를 기준으로, 앞에서부터 A[i] 단어리스트로 대치하여 가능여부를 판단함.
       ㅇ 포함여부[시작IDX][끝IDX] = 포함여부[시작IDX][시작IDX + 단어A의 길이 -1] * 포함여부[시작IDX + 단어A의 길이][끝IDX]

 */

public class Main {
    static String S;
    static String A[];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        int N = Integer.parseInt(br.readLine());
        A = new String[N];
        dp = new int[S.length()][S.length()];

        for (int i = 0; i < S.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        int ans = chkString(0, S.length() - 1);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int chkString(int sIdx, int eIdx) {
        if (dp[sIdx][eIdx] != -1) {
            return dp[sIdx][eIdx];
        }

        // 단어는 중복해서 들어갈 수 있음.
        for (int i = 0; i < A.length; i++) {
            String nWord = A[i];
            int nWordSize = nWord.length();

            // dp[sIdx][eIdx] 가 이전 for i에서 1이되었으면 return
            if (dp[sIdx][eIdx] == 1) {
                return dp[sIdx][eIdx];
            }

            // 체크하는 단어가 문자열보다 길 때,
            if (nWordSize > eIdx - sIdx + 1) {
                dp[sIdx][eIdx] = 0;
                continue;
            }
            // 체크하는 단어가 문자열 앞자리와 다를 때,
            if (!nWord.equals(S.substring(sIdx, sIdx + nWordSize))) {
                if (dp[sIdx][sIdx + nWordSize - 1] == -1) {
                    dp[sIdx][sIdx + nWordSize - 1] = 0;   // 이미 1일 때는 건들면 안됨. (앞 단어의 사이즈가 같은 경우)
                }
                continue;
            }

            // 앞 단어
            dp[sIdx][sIdx + nWordSize - 1] = 1;

            // 단어가 아예 같을 때
            if (nWordSize == eIdx - sIdx + 1) {
                return dp[sIdx][eIdx];
            }

            // 앞단어 * 뒷단어
            dp[sIdx][eIdx] = dp[sIdx][sIdx + nWordSize - 1] * chkString(sIdx + nWordSize, eIdx);
        }

        // 앞단어에서 처음부터 틀릴 경우는 -1로 출력됨. -> 0으로 변경
        return dp[sIdx][eIdx] == -1 ? 0 : dp[sIdx][eIdx];
    }
}