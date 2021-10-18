class Solution {
    static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
            
        chk(numbers, target, 0, 0);
        
        return answer;
    }
    
    private void chk(int[] numbers, int target, int depth, int sum){
        if(depth==numbers.length){
            if(sum==target)
                answer++;
            return;
        }
        
        chk(numbers, target, depth+1, sum+numbers[depth]);
        chk(numbers, target, depth+1, sum-numbers[depth]);
    }
}