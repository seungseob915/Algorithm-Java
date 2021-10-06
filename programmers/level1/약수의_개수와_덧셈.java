import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            if(chk(i))
                answer+=i;
            else
                answer-=i;
        }
        
        return answer;
    }
    
    private boolean chk(int num){
        if(num%Math.sqrt(num)==0)
            return false;
        return true;
    }
}