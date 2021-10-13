class Solution {
    public boolean solution(int x) {
        char num[]=String.valueOf(x).toCharArray();
        int t_num=0;
            
        for(int i=0; i<num.length; i++){
            t_num+=num[i]-'0';
        }
        
        return x%t_num==0?true:false;
    }
}