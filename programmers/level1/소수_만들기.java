class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(chk(nums[i]+nums[j]+nums[k]))
                        answer++;
                }
            }
        }
        return answer;
    }
    
    private boolean chk(int num){
                
        for(int i=2; i*i<= num; i++){
            if(num%i==0)
                return false;
        }
        
        return true;
    }
}