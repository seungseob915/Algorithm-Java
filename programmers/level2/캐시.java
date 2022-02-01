import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map=new HashMap<String, Integer>();
        
        // 대문자 치환
        for(int i=0; i<cities.length; i++){
            cities[i]=cities[i].toUpperCase();
        }
        
        for(int i=0; i<cities.length; i++){
            
            Set<String> keySet=map.keySet();
            
            int maxCnt=-1;
            String maxCity="";
            
            for(String str : keySet){
                int c=map.get(str);
                if(maxCnt<c){
                    maxCnt=c;
                    maxCity=str;
                }
                    
                map.put(str, c+1);
            }
            
            if(map.containsKey(cities[i])){
                answer+=1;
                map.put(cities[i], 0);
                continue;
            }
            
            answer+=5;
            
            // 캐시 사이즈=0 일 때,
            if(cacheSize==0)
               continue;
            
            // 캐시가 Full이 아닐 때,
            if(map.size()<cacheSize){
                map.put(cities[i], 0);
            }
            else{
                map.remove(maxCity);
                map.put(cities[i], 0);
            }             
        }
              
        return answer;
    }
}