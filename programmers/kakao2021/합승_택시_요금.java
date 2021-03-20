package kakao2021;

import java.util.*;

public class 합승_택시_요금 {
	static int INF = 987654321;

    public long solution(int n, int s, int a, int b, int[][] fares) {
        long answer = INF;

        long [][] road=new long[n+1][n+1];
        for(int i=0; i<road.length; i++){
            Arrays.fill(road[i], INF);
            road[i][i]=0;
        }

        for(int i=0; i<fares.length; i++){
            road[fares[i][0]][fares[i][1]]=fares[i][2];
            road[fares[i][1]][fares[i][0]]=fares[i][2];
        }


        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    road[j][k]=Math.min(road[j][k], road[j][i]+road[i][k]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            answer=Math.min(answer, road[s][i]+road[i][a]+road[i][b]);
        }

        return answer;
    }

}
