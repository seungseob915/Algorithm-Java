import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();
        
        HashSet<String> hap=new HashSet<>();
        HashMap<String, Integer> s1=new HashMap<>();
        HashMap<String, Integer> s2=new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++){
            String temp=str1.substring(i, i+2);
            if(temp.charAt(0)<'A' || temp.charAt(0)>'Z')
                continue;
            if(temp.charAt(1)<'A' || temp.charAt(1)>'Z')
                continue;
            
            if(s1.containsKey(temp)){
                int cnt=s1.get(temp);
                s1.replace(temp, cnt+1);
            }
            else{
                s1.put(temp, 1);    
            }
            hap.add(temp);
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String temp=str2.substring(i, i+2);
            if(temp.charAt(0)<'A' || temp.charAt(0)>'Z')
                continue;
            if(temp.charAt(1) <'A' || temp.charAt(1)>'Z')
                continue;
            
            if(s2.containsKey(temp)){
                int cnt=s2.get(temp);
                s2.replace(temp, cnt+1);
            }
            else{
                s2.put(temp, 1);    
            }
            hap.add(temp);
        }
        
        int h_cnt=0;
        int c_cnt=0;
        
        Iterator it=hap.iterator();
        while(it.hasNext()){
            String str=(String)it.next();
            int s1_val=0;
            int s2_val=0;
            
            if(s1.containsKey(str)){
                s1_val=s1.get(str);
            }
            if(s2.containsKey(str)){
                s2_val=s2.get(str);
            }
            
            if(s1_val!=0 && s2_val!=0){
                c_cnt+=Math.min(s1_val, s2_val);
                h_cnt+=Math.max(s1_val, s2_val);
            }
            else{
                h_cnt+=(s1_val)+(s2_val);
            }
        }
        
        double jcd=(double)c_cnt/h_cnt;
        if(h_cnt==0)
            jcd=1;
        
        answer= (int)(jcd*65536);
        return answer;
    }
}