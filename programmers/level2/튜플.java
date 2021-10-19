class Solution {
    public int[] solution(String s) {
        
        s=s.substring(2, s.length()-2);
        s=s.replace("},{", "|");
    
        String s_arr[]=s.split("\\|");
        
        int max_size=0;            
        for(int i=0; i<s_arr.length; i++){
            String temp[]=s_arr[i].split(",");
            max_size=Math.max(max_size, temp.length);
        }
        
        int idx_pos[]=new int[max_size+1];
        
        for(int i=0; i<s_arr.length; i++){
            String temp[]=s_arr[i].split(",");
            idx_pos[temp.length]=i;
        }
        
        boolean chk[]=new boolean[100001];
        int[] answer = new int[max_size];
        
        for(int i=1; i<idx_pos.length; i++){
            String temp[]=s_arr[idx_pos[i]].split(",");

            for(int j=0; j<temp.length; j++){
                 if(chk[Integer.parseInt(temp[j])])                
                     continue;
                
                chk[Integer.parseInt(temp[j])]=true;
                answer[i-1]=Integer.parseInt(temp[j]);
                break;
            }
        }
        
        return answer;
    }
}