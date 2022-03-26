import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
       [BOJ] NO.2533  사회망 서비스

       ㅇ 현재 노드가 얼리어답터가 아니면, 부모 및 자식(있을 경우) 노드는 얼리어답터이어야 한다.
       ㅇ 현재 노드가 얼리어답터면, 주변은 얼리어답터이든 아니든 상관 없다.

 */

public class Main {
    static int N;
    static ArrayList<Integer> adj[], child[];
    static boolean visited[];
    static int pickCnt[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        child = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        pickCnt = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(pickCnt[i], -1);
        }
        for (int i = 1; i <= N; i++) {
            child[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        // Tree 생성
        makeTree(1);
        int ans = chkEarlyAdapter(0, false);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int chkEarlyAdapter(int now, boolean nowEA) {
        if(now==0){
            return Math.min(chkEarlyAdapter(now+1, true), chkEarlyAdapter(now+1, false));
        }

        if(pickCnt[now][nowEA ? 1 : 0]!=-1){
            return pickCnt[now][nowEA ? 1 : 0];
        }

        int pickEA = 1;
        int notPickEA = Integer.MAX_VALUE;

        for (int next : child[now]) {
            pickEA += chkEarlyAdapter(next, true);
        }
        if (nowEA) {
            notPickEA = 0;
            for (int next : child[now]) {
                notPickEA += chkEarlyAdapter(next, false);
            }
        }

        return pickCnt[now][nowEA ? 1 : 0] = Math.min(pickEA, notPickEA);
    }

    private static void makeTree(int now) {
        visited[now] = true;

        for (int next : adj[now]) {
            if (!visited[next]) {
                child[now].add(next);
                makeTree(next);
            }
        }
    }
}

