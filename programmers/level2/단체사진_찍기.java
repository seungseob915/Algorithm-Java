import java.util.*;

class Solution {
    
    static int answer;
    static HashMap<Character, Integer> position=new HashMap<>();
    static char[] friend={'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static String[] c_data;
    
    public int solution(int n, String[] data) {
        c_data=data;
        answer=0;
        for(int i=0; i<friend.length; i++){
            position.put(friend[i], -1);
        }
        
        comb(0);
        
        return answer;
    }
    
    private void comb(int depth){
        if(depth==8){
            if(chk())
                answer++;
            
            return;
        }
            
        for(int i=0; i<8; i++){
            if(position.get(friend[i])!=-1)
                continue;
            
            position.replace(friend[i], depth);
            comb(depth+1);
            position.replace(friend[i], -1);
        }
    }
    
    private boolean chk(){
        for(int i=0; i<c_data.length; i++){
            String str=c_data[i];
            int gap=Math.abs(position.get(str.charAt(0)) - position.get(str.charAt(2)))-1;
            
            if(str.charAt(3)=='='){
                if(gap!=(str.charAt(4)-'0')){
                    return false;
                }
            }
            else if(str.charAt(3)=='<'){
                if(gap>=(str.charAt(4)-'0')){
                    return false;
                }
            }
            else{
                if(gap<=(str.charAt(4)-'0')){
                    return false;
                }
            }
        }
        
        return true;
    }
}