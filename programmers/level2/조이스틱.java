import java.util.*;

class Solution {
    public int solution(String name) {
        String[] alph=new String[name.length()];
        Arrays.fill(alph, "A");

        int dist=alph.length-1;
        int cnt=0;
        
        int fa_idx=-1;  // A 연속 시작 지점
        int fnsa_idx=-1; // A 연속 끝 지점
        int a_len=0;
       
        for(int i=0; i<alph.length; i++){
            if(name.charAt(i)=='A'){
                int t_fa_idx=i;
                int t_fnsa_idx=i;
                
                while(name.charAt(t_fnsa_idx)=='A'){
                    if(t_fnsa_idx==alph.length-1)
                        break;
                    if(name.charAt(t_fnsa_idx+1)!='A'){
                        break;
                    }
                    t_fnsa_idx++;
                }
                
                if(a_len<t_fnsa_idx-t_fa_idx+1){
                    a_len=t_fnsa_idx-t_fa_idx+1;
                    fa_idx=t_fa_idx;
                    fnsa_idx=t_fnsa_idx;
                }
            }
            char n_char=name.charAt(i);
            char a_char=alph[i].charAt(0);
            int min_len=Math.min(('Z'-n_char+1), n_char-a_char);
            cnt+=min_len;
        }
        
        // 좌우 거리 계산 (맨뒤에 연속된 A 갯수만큼 제거)
        for(int i=name.length()-1; i>=0; i--){
            if(name.charAt(i)!='A')
                break;
            dist--;
        }
        
        if(fa_idx!=-1){
            if(fa_idx==0 && fnsa_idx==alph.length-1)
                return 0;
            
            dist=Math.min(dist, (fa_idx-1)*2 + alph.length-1-fnsa_idx);
        }
        
        return cnt+dist;
    }
}