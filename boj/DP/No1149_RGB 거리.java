import java.io.*;
import java.util.StringTokenizer;

/*
       [BOJ] NO.1149  RGB 거리

       ㅇ 현재 칸 기준, 전 칸과 색깔이 달라야 하므로, 현재 칸과 이전 칸의 idx가 다른 것의 min 값을 확보한다.
       ㅇ ex) sum[2][1]= min(sum[1][2], sum[1][3]) + cost[2][1];

 */

public class Main {

    static int N;
    static int sum[][];
    static int cost[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][4];
        sum = new int[N + 1][4];

        for(int i=1; i<=N; i++){
            StringTokenizer stk=new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                cost[i][j]=Integer.parseInt(stk.nextToken());
                if(i==1){
                    sum[i][j]=cost[i][j];
                }
            }
        }

        for(int i=2; i<=N; i++){
            sum[i][1]=Math.min(sum[i-1][2], sum[i-1][3])+cost[i][1];
            sum[i][2]=Math.min(sum[i-1][1], sum[i-1][3])+cost[i][2];
            sum[i][3]=Math.min(sum[i-1][1], sum[i-1][2])+cost[i][3];
        }

        int ans=Math.min(Math.min(sum[N][1], sum[N][2]), sum[N][3]);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

