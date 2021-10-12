class Solution {
    public int solution(int num) {
        return go(num,0);
    }
    
    private static int go(long num, int turn){
        if(turn==499){
            return -1;
        }
        
        if(num==1L){
            return turn;
        }
        else if(num%2==0L){
            return go(num/2, turn+1);
        }
        else{
            return go(num*3+1, turn+1);
        }
    }
}