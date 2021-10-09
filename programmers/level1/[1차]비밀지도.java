class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<arr1.length; i++){
            int temp=arr1[i]|arr2[i];
            String str=Integer.toBinaryString(temp);
            
            int needZero=n-str.length();
            String zero="";
            
            for(int j=0; j<needZero; j++)
                zero+=" ";
            
            answer[i]=(zero+str).replace("1", "#").replace("0", " ");           
        }
        
       
        return answer;
    }
}