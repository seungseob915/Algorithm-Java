import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(stk.nextToken());
        int N=Integer.parseInt(stk.nextToken());


        int board[][] = new int[M + 1][N + 1];
        int answer=0;

        for (int i = 1; i <= M; i++) {
            stk=new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num=Integer.parseInt(stk.nextToken());
                if (num > 0)
                    continue;
                board[i][j] = Math.min(Math.min(board[i - 1][j - 1], board[i - 1][j]), board[i][j - 1]) + 1;
                answer=Math.max(answer, board[i][j]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}