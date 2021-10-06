class Solution {
    public int solution(int[][] sizes) {
        
        int mw=0;
        int mh=0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                mw=Math.max(mw, sizes[i][1]);
                mh=Math.max(mh, sizes[i][0]);
            }
            else{ 
                mw=Math.max(mw, sizes[i][0]);
                mh=Math.max(mh, sizes[i][1]);
            }
        }
        
        return mw*mh;
    }
}