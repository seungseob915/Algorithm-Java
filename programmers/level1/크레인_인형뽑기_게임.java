import java.util.*;

class Solution {
    
    static int N;
    static int n_board[][];
    static ArrayList<Integer> doll=new ArrayList<>();    
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        N=board.length;
        n_board=board;
                               
        for(int i=0; i<moves.length; i++){
            int now=moves[i]-1;
            
            for(int j=0; j<N; j++){
                if(n_board[j][now]!=0){
                    if(doll.size() !=0  && n_board[j][now]==doll.get(doll.size()-1) ){
                        answer+=2;
                        doll.remove(doll.size()-1);
                    }
                    else{
                        doll.add(n_board[j][now]);
                    }
                    n_board[j][now]=0;
                    break;
                }
            }
        }
        
        return answer;
    }
}