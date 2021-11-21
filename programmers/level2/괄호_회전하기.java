import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(chk(s))
            answer++;
        
        for(int i=1; i<s.length(); i++){
            String temp=s.substring(i, s.length())  + s.substring(0, i);
            if(chk(temp))
                answer++;
        }
        
        return answer;
    }
    
    private static boolean chk(String str){
        if(str.length()%2!=0)
            return false;
        
        Stack<Character> stk=new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char now=str.charAt(i);
            
            if(now==')'){
                if(stk.empty())
                    return false;
                if(stk.peek()=='('){
                    stk.pop();
                }
            }
            else if(now==']'){
                if(stk.empty())
                    return false;
                if(stk.peek()=='['){
                    stk.pop();
                }   
            }
            else if(now=='}'){
                if(stk.empty())
                    return false;
                if(stk.peek()=='{'){
                    stk.pop();
                }   
            }
            else{
                stk.push(now);
            }
        }
        
        return stk.empty();
    }
}