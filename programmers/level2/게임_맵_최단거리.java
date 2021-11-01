import java.util.*;

class Solution {
    static int dx[]={0,0,-1,1};
    static int dy[]={-1,1,0,0};
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int chk[][]=new int[maps.length][maps[0].length];
        for(int i=0; i<maps.length; i++)
            Arrays.fill(chk[i], -1);
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        chk[0][0]=1;
        
    Outter:while(!q.isEmpty()){
            int[] now=q.poll();
            
            for(int d=0; d<4; d++){
                int nx=now[0]+dx[d];
                int ny=now[1]+dy[d];
                
                if(nx<0 || nx>maps.length-1 || ny<0 || ny>maps[0].length-1)
                    continue;
                if(chk[nx][ny]!=-1)
                    continue;
                if(maps[nx][ny]==0)
                    continue;
                
                if(nx==maps.length-1 && ny==maps[0].length-1){
                    answer=chk[now[0]][now[1]]+1;
                    break Outter;
                }
                
                q.add(new int[]{nx, ny});
                chk[nx][ny]=chk[now[0]][now[1]]+1;
            }
        }
        
        return answer;
    }
}