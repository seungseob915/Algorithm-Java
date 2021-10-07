import java.util.*;

class Solution {
    
    public int[] solution(int n, long left, long right) {
        
        int size=(int)(right-left)+1;
        
        int[] answer=new int[size];

        long sx=left/n;
        long sy=left%n;
        long ex=right/n;
        long ey=right%n;

        int cnt=0;
        
        for(int i=(int)sx; i<=(int)ex; i++){
            if((int)sx==(int)ex){
                for(int j=(int)sy; j<=(int)ey; j++){
                    answer[cnt++]=(i<j)?j+1:i+1;
                }
            }
            else if(i==(int)sx){
                for(int j=(int)sy; j<n; j++){
                    answer[cnt++]=(i<j)?j+1:i+1;
                }
            }
            else if(i==(int)ex){
                for(int j=0; j<=(int)ey; j++){
                    answer[cnt++]=(i<j)?j+1:i+1;
                }
            }
            else{
                for(int j=0; j<n; j++){
                    answer[cnt++]=(i<j)?j+1:i+1;
                }
            }

        }
        
        return answer;

    }
}