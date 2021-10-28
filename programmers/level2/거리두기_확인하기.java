import java.util.*;

// P: 응시자 / 0: 빈테이블 / X : 파티션
class Solution {
    
    static int dx[]={-1,1,0,0};
    static int dy[]={0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            char[][] board=new char[5][5];
            for(int j=0; j<5; j++){
                board[j]=places[i][j].toCharArray();
            }
                    
            answer[i]=chk(board);
        }
        
        return answer;
    }
    
    private static int chk(char[][] board){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j]!='P')
                    continue;
                
                Queue<int[]> q=new LinkedList<>();
                int check[][]=new int[5][5];
                
                q.add(new int[]{i, j});
                
                for(int k=0; k<5; k++)
                    Arrays.fill(check[k], -1);
                check[i][j]=0;
                
                while(!q.isEmpty()){
                    int[] now=q.poll();
                    if(check[now[0]][now[1]]==2)
                        continue;
                    
                    for(int d=0; d<4; d++){
                        int nx=now[0]+dx[d];
                        int ny=now[1]+dy[d];
                        
                        if(nx<0 || nx>4 || ny<0 || ny>4)
                            continue;
                        if(check[nx][ny]!=-1)
                            continue;
                        if(board[nx][ny]=='X')
                            continue;
                        if(board[nx][ny]=='P'){
                            return 0;
                        }
                        
                        q.add(new int[]{nx,ny});
                        check[nx][ny]=check[now[0]][now[1]]+1;
                    }
                }
                
            }
        }
                
        return 1;
    }
}