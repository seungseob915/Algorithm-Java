class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0]= n>m?gcd(n,m):gcd(m,n);
        answer[1]= n*m/answer[0];
        
        return answer;
    }
    
    private static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        
        int r=a%b;
        return gcd(b, r);
        
    }
}