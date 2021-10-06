import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        int[] candidate=d;
        Arrays.sort(candidate);
        
        
        for(int i=0; i<candidate.length; i++){
            if(budget<candidate[i]){
                break;
            }
            budget-=candidate[i];
            answer++;
        }
        
        return answer;
    }
}