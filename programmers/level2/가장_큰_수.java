import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] s_numbers=new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            s_numbers[i]=String.valueOf(numbers[i]);
        }
        
        Arrays.sort(s_numbers, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String ss1=s1+s2;
                String ss2=s2+s1;
                
                return ss2.compareTo(ss1);
            }
        }
        );
        
        for(int i=0; i<s_numbers.length; i++){
           if(answer.equals("") && s_numbers[i].equals("0"))
               continue;
            answer+=s_numbers[i];
        }
        
        return answer.equals("")?"0":answer;
    }
}