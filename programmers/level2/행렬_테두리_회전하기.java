class Solution {
    static int board[][];
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        board=new int[rows+1][columns+1];
        
        int cnt=1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++){
                board[i][j]=cnt++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            answer[i]=rotate(queries[i]);
        }
        
        return answer;
    }
    
    private static int rotate(int[] query){
        int x1=query[0];
        int y1=query[1];
        int x2=query[2];
        int y2=query[3];
        
        int cpy_x1_y1=board[x1][y1];
        int low_num=cpy_x1_y1;
        
        // 1. 좌측 면
        for(int i=x1; i<x2; i++){
            board[i][y1]=board[i+1][y1];
            low_num=Math.min(low_num, board[i][y1]);
        }
        
        // 2. 하단 면
        for(int i=y1; i<y2; i++){
            board[x2][i]=board[x2][i+1];
            low_num=Math.min(low_num, board[x2][i]);
        }
        
        // 3. 우측 면
        for(int i=x2; i>x1; i--){
            board[i][y2]=board[i-1][y2];
            low_num=Math.min(low_num, board[i][y2]);
        }
        
        // 4. 상단 면
        for(int i=y2; i>y1+1; i--){
            board[x1][i]=board[x1][i-1];
            low_num=Math.min(low_num, board[x1][i]);
        }
        
        board[x1][y1+1]=cpy_x1_y1;
        
        return low_num;
    }
}