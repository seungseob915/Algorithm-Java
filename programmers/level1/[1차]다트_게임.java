import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        Stack<Character> stack=new Stack<>();
        dartResult=dartResult.replace("10", "F");
        
        for(int i=0; i<dartResult.length(); i++)
            stack.push(dartResult.charAt(i));
        
        int gop=1;
        int prev_pow=1;
        int num_cnt=0;
        int[] chk={0,0,0,0};
        
        while(!stack.empty()){
            char now=stack.pop();

            if(now=='T'){
                prev_pow=3;
            }
            else if(now=='D'){
                prev_pow=2;
            }
            else if(now=='S'){
                prev_pow=1;
            }
            else if(now=='F' || (now>='0' && now<='9')){
                int temp=0;
                
                if(now=='F')
                    temp=10;
                else
                    temp=now-'0';
                
                answer+=(Math.pow(temp,prev_pow)*gop)*Math.pow(2,chk[2-num_cnt]);
                
                if(gop<0){
                    gop*=-1;
                }
                num_cnt++;
            }
            else if(now=='*'){
                if(num_cnt==2)
                    chk[2-num_cnt]++;
                else{
                    chk[2-num_cnt]++;
                    chk[2-num_cnt-1]++;
                }
            }
            else if(now=='#'){
                gop*=-1;
            }
        }
        
        
        return answer;
    }
}