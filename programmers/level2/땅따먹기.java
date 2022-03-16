import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int prevScore[]=new int[]{land[0][0], land[0][1], land[0][2], land[0][3]};
        int nowScore[]=new int[4];

        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){ // 이전
                for(int k=0; k<4; k++){ // 현재
                    if(j==k){
                        continue;
                    }
                    nowScore[k]=Math.max(nowScore[k], prevScore[j]+land[i][k]);
                }
            }
            for(int j=0; j<4; j++){
                prevScore[j]=nowScore[j];
                nowScore[j]=0;
            }
        }

        Arrays.sort(prevScore);

        answer=prevScore[3];

        return answer;
    }
}