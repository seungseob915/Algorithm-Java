import java.util.*;

class Solution {
    static long answer;
    static HashMap<String, Integer> buho;
    
    public long solution(String expression) {
        answer=0;
        
        expression=expression.replace("+", " + ")
                        .replace("-", " - ")
                        .replace("*", " * ")
                        .replace("/", " / ");
        
        String[] str=expression.split(" ");
        buho=new HashMap<>();
        
        String[] order=new String[4];
        int odr_idx=0;
        for(int i=1; i<str.length-1; i+=2){
            if(buho.containsKey(str[i]))
                continue;
            buho.put(str[i], 0);
            order[odr_idx++]=str[i];
        }
        
        buhoComb(str,buho,order,0);
     
        return answer;
    }
    
    private static void buhoComb(String[] str, HashMap<String, Integer> buho, String[] order, int depth){
        if(depth==buho.size()){
            // 후위표기식 변환
            Stack<String> stk=new Stack<>();
            String[] temp=new String[str.length];
            int temp_idx=0;
            
            for(int i=0; i<str.length; i++){
                if(i%2==1){
                    if(stk.empty()){
                        stk.push(str[i]);
                    }
                    else{
                        int n_score=buho.get(str[i]);
                        while(true){
                            if(stk.empty()){
                                stk.push(str[i]);
                                break;
                            }
                            int score=buho.get(stk.peek());
                            
                            if(n_score<=score){
                                temp[temp_idx++]=stk.pop();
                            }
                            else{
                                stk.push(str[i]);
                                break;
                            }
                        }
                    }
                }
                else{
                   temp[temp_idx++]=str[i];
                }
            }
            
            while(!stk.empty()){
                temp[temp_idx++]=stk.pop();
            }
            
            // 계산
            Stack<Long> cal=new Stack<>();
            
            for(int i=0; i<temp.length; i++){
                if(buho.containsKey(temp[i])){
                    Long b=cal.pop();
                    Long a=cal.pop();

                    if(temp[i].equals("+")){
                        cal.push(a+b);
                    }
                    else if(temp[i].equals("-")){
                        cal.push(a-b);
                    }
                    else {
                        cal.push(a*b);
                    }
                }
                else{
                   cal.push(Long.parseLong(temp[i]));    
                }
            }
            answer=Math.max(answer, Math.abs(cal.pop()));
            
            return;
        }
        
        for(int i=0; i<buho.size(); i++){
            if(buho.get(order[i])!=0)
                continue;
            
            buho.replace(order[i], depth+1);
            buhoComb(str, buho, order, depth+1);
            buho.replace(order[i], 0);
        }
    }
}