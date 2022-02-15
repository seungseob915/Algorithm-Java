ㅁimport java.io.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int hx[]={-2,-2,-1,1,2,2,1,-1};
    static int hy[]={-1,1,2,2,1,-1,-2,-2};
    static int dx[]={0,0,-1,1};
    static int dy[]={-1,1,0,0};

    static class Monkey{
        int x, y, kCnt;

        public Monkey(int x, int y, int kCnt) {
            this.x = x;
            this.y = y;
            this.kCnt = kCnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int k=Integer.parseInt(br.readLine());
        StringTokenizer stk=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(stk.nextToken());
        int w=Integer.parseInt(stk.nextToken());

        int [][] board = new int[w][h];
        int [][][] chk = new int[w][h][k+1];

        for(int i=0; i<w; i++){
            stk=new StringTokenizer(br.readLine());
            for(int j=0; j<h; j++){
                board[i][j]=Integer.parseInt(stk.nextToken());
                Arrays.fill(chk[i][j], -1);
            }
        }

        //BFS
        int sx=0;
        int sy=0;

        Queue<Monkey> q=new LinkedList<>();
        q.add(new Monkey(sx, sy, 0));
        chk[sx][sy][0]=0;

        while(!q.isEmpty()){
            Monkey now=q.poll();

            // 1. 말 방식으로 안갈때
            for(int dir=0; dir<4; dir++){
                int nx=now.x+dx[dir];
                int ny=now.y+dy[dir];

                if(nx<0 || nx>w-1 || ny<0 || ny>h-1)
                    continue;
                if(board[nx][ny]==1)
                    continue;
                if(chk[nx][ny][now.kCnt]!=-1)
                    continue;

                q.add(new Monkey(nx, ny, now.kCnt));
                chk[nx][ny][now.kCnt]=chk[now.x][now.y][now.kCnt]+1;
            }
            // 2. 말 방식으로 갈때
            if(now.kCnt==k)
                continue;
            for(int dir=0; dir<8; dir++){
                int nx=now.x+hx[dir];
                int ny=now.y+hy[dir];
                int nkCnt=now.kCnt+1;

                if(nx<0 || nx>w-1 || ny<0 || ny>h-1)
                    continue;
                if(board[nx][ny]==1)
                    continue;
                if(chk[nx][ny][nkCnt]!=-1)
                    continue;

                q.add(new Monkey(nx, ny, nkCnt));
                chk[nx][ny][nkCnt]=chk[now.x][now.y][now.kCnt]+1;
            }
        }

        int ret=987654321;

        for(int i=0; i<=k; i++){
            if(chk[w-1][h-1][i]==-1)
                continue;
            ret=Math.min(ret, chk[w-1][h-1][i]);
        }

        bw.write(String.valueOf(ret==987654321?-1:ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
