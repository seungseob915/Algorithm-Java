import java.util.*;

class Solution {
    public long solution(long n) {
        String str=""+n;
        char c[]=str.toCharArray();
        
        Arrays.sort(c);
        str="";
        
        for(int i=c.length-1; i>=0; i--)
            str+=String.valueOf(c[i]);
        
        return Long.parseLong(str);
    }
}