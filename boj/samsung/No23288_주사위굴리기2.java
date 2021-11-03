import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Dice{
    int x=1;
    int y=1;
    int d=0;
}

public class Main {
    static int[][] board;
    static int[] dice= {0, 1, 2, 3, 4, 5, 6};
    static Dice dice_info=new Dice();
    static int r, c, move;
    static int score=0;

    static int[] dx={0, 1, 0, -1};
    static int[] dy={1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        r=Integer.parseInt(input[0]);
        c=Integer.parseInt(input[1]);
        move=Integer.parseInt(input[2]);
        board=new int[r+1][c+1];

        for(int i=1; i<=r; i++){
            String[] b_input=br.readLine().split(" ");
            for(int j=0; j<c; j++){
                board[i][j+1]=Integer.parseInt(b_input[j]);
            }
        }

        for(int i=0; i<move; i++){
            int dir= dice_info.d;
            int nx=dice_info.x+dx[dir];
            int ny=dice_info.y+dy[dir];

            if(nx<1 || nx>r || ny<1 || ny>c){
                if(dir==0)
                    dir=2;
                else if(dir==1)
                    dir=3;
                else if(dir==2)
                    dir=0;
                else
                    dir=1;

                nx=dice_info.x+dx[dir];
                ny=dice_info.y+dy[dir];
            }

            // 주사위 이동
            moving(dir);
            
            // 숫자 비교
            int bottom=dice[6];
            int b_num=board[nx][ny];

            // 점수 획득
            score+=getScore(b_num, nx, ny);

            if(b_num<bottom){
                dir+=1;
                if(dir>3)
                    dir=0;
            }
            else if(b_num>bottom){
                dir-=1;
                if(dir<0)
                    dir=3;
            }

            dice_info.d=dir;

            dice_info.x=nx;
            dice_info.y=ny;
        }

        bw.write(String.valueOf(score));
        bw.flush();
        bw.close();
    }

    private static int getScore(int b_num, int nx, int ny) {

        boolean chk[][]=new boolean[r+1][c+1];

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{nx, ny});
        chk[nx][ny]=true;
        int cnt=1;

        while(!q.isEmpty()){
            int[] now=q.poll();

            for(int k=0; k<4; k++){
                int nxt_x=now[0]+dx[k];
                int nxt_y=now[1]+dy[k];

                if(nxt_x<1 || nxt_x>r || nxt_y<1 || nxt_y>c)
                    continue;
                if(chk[nxt_x][nxt_y])
                    continue;
                if(board[nxt_x][nxt_y]!=b_num)
                    continue;

                q.add(new int[]{nxt_x, nxt_y});
                chk[nxt_x][nxt_y]=true;
                cnt++;
            }
        }

        return cnt*b_num;
    }

    private static void moving(int dir) {
        if(dir==0){
            int temp=dice[1];
            dice[1]=dice[4];
            dice[4]=dice[6];
            dice[6]=dice[3];
            dice[3]=temp;
        }
        else if(dir==1){
            int temp=dice[2];
            dice[2]=dice[6];
            dice[6]=dice[5];
            dice[5]=dice[1];
            dice[1]=temp;
        }
        else if(dir==2){
            int temp=dice[3];
            dice[3]=dice[6];
            dice[6]=dice[4];
            dice[4]=dice[1];
            dice[1]=temp;
        }
        else{
            int temp=dice[1];
            dice[1]=dice[5];
            dice[5]=dice[6];
            dice[6]=dice[2];
            dice[2]=temp;
        }
    }

}

