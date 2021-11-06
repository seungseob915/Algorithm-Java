class Solution
{
    static int step=0;
    
    public int solution(int n, int a, int b)
    {
        int max_turn=(int) (Math.log(n)/Math.log(2));
        
        find(n, 1, n, 0, a, b);
        
        return max_turn-step;
    }

    private void find(int n, int start, int end, int s, int a, int b){
        
        int size=n/2;
        int f_block_s=start;
        int f_block_e=start+size-1;
        int s_block_s=start+size;
        int s_block_e=end;

        
        int a_pos=0;    // 첫 블록으로 초기화
        int b_pos=0;
        
        if(a>=s_block_s && a<=s_block_e)
            a_pos=1;
        if(b>=s_block_s && b<=s_block_e)
            b_pos=1;
            
        if(a_pos!=b_pos){
            step=s;
            return;
        }
        
        if(a_pos==0){
            find(size, f_block_s, f_block_e, s+1, a, b);
        }
        else{
            find(size, s_block_s, s_block_e, s+1, a, b);
        }
    }
}