import java.util.*;

class Solution {
    static boolean chk[];
    static String[][] relations;
    static int rows;
    static HashSet<String> answer_set=new HashSet<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
            
        relations=relation;
        rows=relation.length;
        int cols=relation[0].length;
        chk=new boolean[cols];
        
        comb(0, 0, cols);
        
        String[] s=answer_set.toArray(new String[0]);
        boolean[] ans_chk=new boolean[s.length];
        
        for(int i=0; i<s.length; i++){
            String[] now=s[i].split("");    
            
            for(int j=0; j<s.length; j++){
                if(i==j)
                    continue;
                
                boolean flag=true;
                
                for(int k=0; k<now.length; k++){
                    if(!s[j].contains(now[k])){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    ans_chk[j]=true;
            }
        }
        
        for(int i=0; i<s.length; i++)
            if(!ans_chk[i])
                answer++;
            
               
        return answer;
    }
    
    private static void comb(int prev_idx, int now_cols_cnt, int max_cols){

        for(int i=prev_idx; i<max_cols; i++){
            if(chk[i])
                continue;
            
            chk[i]=true;
            
            if(fin(max_cols)){
                chk[i]=false;
                continue;
            }
            
            comb(i+1, now_cols_cnt+1, max_cols);
            chk[i]=false;
        }
    }
    
    private static boolean fin(int max_cols){
        
        HashSet<ArrayList<String>> set=new HashSet<>();
        
        String str="";
        
        for(int j=0; j<max_cols; j++){
            if(chk[j]){
                str+=j;
            }
        }

        for(int i=0; i<rows; i++){
            ArrayList<String> temp=new ArrayList<>();
            for(int j=0; j<max_cols; j++){
                if(chk[j]){
                    temp.add(relations[i][j]);
                }
            }
            set.add(temp);
        }
        
        if(set.size()==rows)
            answer_set.add(str);
        
        return set.size()==rows? true:false;
        
    }
}