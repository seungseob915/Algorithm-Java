class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        boolean[] w_chk=new boolean[win_nums.length];

        int w_cnt=0;
        int z_cnt=0;

        for(int i=0; i<lottos.length; i++)
            if(lottos[i]==0)
                z_cnt++;

        for(int i=0; i<win_nums.length; i++){
            for(int j=0; j<lottos.length; j++){
                if(win_nums[i]==lottos[j]){
                    w_chk[i]=true;
                    w_cnt++;
                    break;
                }
            }
        }

        int max_res=7-(w_cnt+z_cnt);
        int min_res=7-w_cnt;

        if(max_res>=6)
            max_res=6;
        if(min_res>=6)
            min_res=6;

        int[] answer = {max_res, min_res};

        return answer;
    }
}