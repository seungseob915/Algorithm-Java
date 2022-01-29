import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Hongik{
    int x, y, usedMagic;

    public Hongik(int x, int y, int usedMagic) {
        this.x = x;
        this.y = y;
        this.usedMagic = usedMagic;
    }
}

public class Main {

    static int N, M, Hx, Hy, Ex, Ey, answer=987654321;
    static int board[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(stk.nextToken());
        Hy = Integer.parseInt(stk.nextToken());


        stk = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(stk.nextToken());
        Ey = Integer.parseInt(stk.nextToken());

        board=new int[N+1][M+1];

        int chk[][][]=new int[N+1][M+1][2];

        for(int i=1; i<=N; i++){
            stk=new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                board[i][j]=Integer.parseInt(stk.nextToken());
                Arrays.fill(chk[i][j], -1);
            }
        }

        Queue<Hongik> q=new LinkedList<Hongik>();
        q.add(new Hongik(Hx, Hy, 0));

        chk[Hx][Hy][0]=0;

        while(!q.isEmpty()){
            Hongik now=q.poll();

            for(int dir=0; dir<4; dir++){
                int nx=now.x+dx[dir];
                int ny=now.y+dy[dir];
                int nUsedMagic = now.usedMagic;

                if(nx<1 || nx>N || ny<1 || ny>M)
                    continue;
                if(chk[nx][ny][now.usedMagic]!=-1) {
                    continue;
                }

                //벽돌 만났을때, 현재 지팡이를 안썼으면 go, 이미 썼으면 stop
                if(board[nx][ny]==1){
                    if(now.usedMagic==1)
                        continue;
                    else
                        nUsedMagic=1;
                }

                // 최종지점 도달 시
                if(nx==Ex && ny== Ey) {
                    chk[nx][ny][nUsedMagic]=chk[now.x][now.y][now.usedMagic]+1;
                    continue;
                }

                q.add(new Hongik(nx, ny, nUsedMagic));
                chk[nx][ny][nUsedMagic]=chk[now.x][now.y][now.usedMagic]+1;
            }

        }

        if(chk[Ex][Ey][0]>=chk[Ex][Ey][1])
            answer=chk[Ex][Ey][1];
        else
            answer=chk[Ex][Ey][0];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}