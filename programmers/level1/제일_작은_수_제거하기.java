import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] cpy=arr.clone();
        
        Arrays.sort(cpy);
        int min=cpy[0];

        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==min)
                continue;
            
            list.add(arr[i]);
        }
        
        if(list.size()<=1)
            return new int[]{-1};
        
        int answer[]=new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}