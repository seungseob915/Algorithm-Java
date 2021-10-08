import java.util.*;

class Info{
    int no;
    double win_per;
    int hvy_win;
    int weight;
    
    public Info(){
        
    }
    public Info(int no, double win_per, int hvy_win, int weight){
        this.no=no;
        this.win_per=win_per;
        this.hvy_win=hvy_win;
        this.weight=weight;
    }
}

class Solution {
            
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        Info[] infos=new Info[weights.length];
        
        for(int i=0; i<head2head.length; i++){
            int n_weight=weights[i];
            int n_hvy_win=0;
            int n_win_cnt=0;
            int fight_cnt=0;
            
            for(int j=0; j<head2head[i].length(); j++){
                char t=head2head[i].charAt(j);
                
                if(t=='N'){
                    continue;
                }
                else if(t=='W'){
                    if(n_weight < weights[j]){
                        n_hvy_win++;
                    }
                    n_win_cnt++;
                }
                fight_cnt++;
            }
            
            if(fight_cnt==0)
                fight_cnt=1;
            
            infos[i]=new Info(i+1, (double)n_win_cnt/(fight_cnt), n_hvy_win, n_weight);
        }
        
        Arrays.sort(infos, new Comparator<Info>(){
            @Override
            public int compare(Info i1, Info i2){
                if(i1.win_per == i2.win_per){
                    if(i1.hvy_win != i2.hvy_win){
                        return i1.hvy_win>i2.hvy_win?-1:1;
                    }
                    else{
                        if(i1.weight!=i2.weight)
                            return i1.weight>i2.weight?-1:1;
                        else
                            return i1.no<i2.no?-1:1;
                    }
                        
                }
                else
                    return i1.win_per>i2.win_per?-1:1;
            }
        });
        
        for(int i=0; i<weights.length; i++){
            answer[i]=infos[i].no;
        }
        
        return answer;
    }
}