import java.util.*;

class Solution {

    static ArrayList<Integer> answer=new ArrayList<Integer>();
    static int rows;
    static int cols;
    static int dx[]={-1, 0, 1, 0};
    static int dy[]={0, 1, 0, -1};
    static char board[][];
    static boolean chk[][][];

    public int[] solution(String[] grid){
        rows=grid.length;
        cols=grid[0].length();

        board=new char[rows][cols];
        chk=new boolean[rows][cols][4];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                board[i][j]=grid[i].charAt(j);
            }
        }
        
        // 탐색 시작(시작지점)
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                for(int dir=0; dir<4; dir++){
                    if(chk[i][j][dir]==true)
                        continue;
                    int ret=findRoad(i, j, dir);

                    if(ret==-1)
                        continue;
                    else
                        answer.add(ret);
                }
            }
        }

        int ans[]=new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            ans[i]=answer.get(i);
        }

        Arrays.sort(ans);

        return ans;
    }

    private static int findRoad(int i, int j, int dir) {
        // 현재위치
        int nx=i;
        int ny=j;
        int nd=dir;
        int step=0;
        
        chk[nx][ny][nd]=true;

        // 시작위치 i, j로 돌아오면 성공
        while(true){
            step++;
            nx=nx+dx[nd];
            ny=ny+dy[nd];

            //칸을 넘어갔을 때
            if(nx < 0) {
                nx = rows - 1;
            }
            else if(nx>rows-1) {
                nx = 0;
            }
            else if(ny<0) {
                ny = cols - 1;
            }
            else if(ny>cols-1) {
                ny = 0;
            }


            // 방향은 다음칸 방향으로 바꾼다
            if(board[nx][ny]=='L') {
                nd = nd - 1;
                if(nd==-1)
                    nd=3;
            }
            else if(board[nx][ny]=='R'){
                nd=nd+1;
                if(nd==4){
                    nd=0;
                }
            }

            // 성공(사이클 생성)
            if(nx==i && ny==j && dir==nd)
                break;

            if(chk[nx][ny][nd]==true){
                return -1;
                  //step=-1;
            }

            chk[nx][ny][nd]=true;
        }
        return step;
    }
}
