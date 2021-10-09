import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        
        for(int i=0; i<scores[0].length; i++){
            int[] arrs=new int[scores.length];
            int myscore=-1;
            int total=0;
            
            for(int j=0; j<scores.length; j++){
                if(i==j){
                    myscore=scores[j][i];
                }
                arrs[j]=scores[j][i];
                total+=scores[j][i];
            }
            
            Arrays.sort(arrs);
            int min=arrs[0];
            int max=arrs[arrs.length-1];
            int cnt=arrs.length;
            
            if(myscore==min && arrs[1]!=min){
                cnt--;
                total-=myscore;
            }
            if(myscore==max && arrs[arrs.length-2]!=max){
                cnt--;
                total-=myscore;
            }
            
            double avg=((double)total/cnt);

            
            if(avg>=90)
                answer+="A";
            else if(avg>=80)
                answer+="B";
            else if(avg>=70)
                answer+="C";
            else if(avg>=50)
                answer+="D";
            else
                answer+="F";
        }
        
        return answer;
    }
}