import java.util.*;

class Ratio{
    int sn;
    double ratio;

    public Ratio(int sn, double ratio){
        this.sn=sn;
        this.ratio=ratio;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {


        int[] fail=new int[N+1];        
        int[] reach=new int[N+1];

        for(int i=0; i<stages.length; i++){
            int now=stages[i];
            if(now<=N){
                fail[now]++;
                reach[now]++;
            }
            while(now>1){
                now--;
                reach[now]++;
            }
        }

        Ratio[] fail_ratio=new Ratio[N];

        for(int i=0; i<N; i++){
            if(reach[i+1]==0)
                fail_ratio[i]=new Ratio(i+1, 0);
            else
                fail_ratio[i]=new Ratio(i+1, (double)fail[i+1]/reach[i+1]);
        }

        Arrays.sort(fail_ratio, new Comparator<>() {
            @Override
            public int compare(Ratio n1, Ratio n2) {
                if(n1.ratio<n2.ratio)
                    return 1;
                else if(n1.ratio==n2.ratio){
                    return 0;
                }
                else
                    return -1;
            }
        });

        int[] answer=new int[N];
        int i=0;

       for(Ratio fr : fail_ratio){
           answer[i++]=fr.sn;
           System.out.println(fr.ratio);
       }

        return answer;
    }
}