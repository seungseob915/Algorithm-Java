import java.util.*;

class Solution {
    static int dx[]={0,0,-1,1};
    static int dy[]={-1,1,0,0};
    static boolean chk[][];

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        chk=new boolean[m][n];
                
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !chk[i][j]){
                    maxSizeOfOneArea=Math.max(chk(i, j, picture), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int chk(int m, int n, int[][] picture){
        Queue<int []> queue=new LinkedList<>();
        int b_size=1;
        int now_no=picture[m][n];
        chk[m][n]=true;
        queue.add(new int[]{m, n});
        
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            
            for(int d=0; d<4; d++){
                int nx=now[0]+dx[d];
                int ny=now[1]+dy[d];
                
                if(nx<0 || nx>picture.length-1 || ny<0 || ny>picture[0].length-1)
                    continue;
                if(picture[nx][ny]!=now_no)
                    continue;
                if(chk[nx][ny])
                    continue;
                
                queue.add(new int[]{nx, ny});
                chk[nx][ny]=true;
                b_size++;
            }
        }
        
        return b_size;
    }
}