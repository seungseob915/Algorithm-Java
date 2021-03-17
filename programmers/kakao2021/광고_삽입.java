import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long time_cnt[] = new long[360000];
        String[] p_time = play_time.split(":");
        String[] a_time = adv_time.split(":");
        int end_time = Integer.parseInt(p_time[0]) * 3600 + Integer.parseInt(p_time[1]) * 60
                + Integer.parseInt(p_time[2]);
        int ad_time = Integer.parseInt(a_time[0]) * 3600 + Integer.parseInt(a_time[1]) * 60
                + Integer.parseInt(a_time[2]);

        for (int i = 0; i < logs.length; i++) {
            StringTokenizer stk = new StringTokenizer(logs[i], "-");
            String[] s_time = stk.nextToken().split(":");
            String[] e_time = stk.nextToken().split(":");
            int stime = Integer.parseInt(s_time[0]) * 3600 + Integer.parseInt(s_time[1]) * 60
                    + Integer.parseInt(s_time[2]);
            int etime = Integer.parseInt(e_time[0]) * 3600 + Integer.parseInt(e_time[1]) * 60
                    + Integer.parseInt(e_time[2]);

            time_cnt[stime] += 1;
            time_cnt[etime] -= 1;
        }

        for (int i = 1; i <= end_time; i++) {
            time_cnt[i] = time_cnt[i] + time_cnt[i - 1];
        }
        for (int i = 1; i <= end_time; i++) {
            time_cnt[i] = time_cnt[i] + time_cnt[i - 1];
        }

        long ret = time_cnt[ad_time-1];
        int time = 0;

        for(int i=0; i+ad_time<=end_time; i++){
            long sum=time_cnt[i+ad_time]-time_cnt[i];

            if(sum>ret){
                time=i+1;
                ret=sum;
            }
        }

        String answer = "";
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = time % 60;

        if (h < 10)
            answer += ("0" + String.valueOf(h) + ":");
        else
            answer += (String.valueOf(h) + ":");

        if (m < 10)
            answer += ("0" + String.valueOf(m) + ":");
        else
            answer += (String.valueOf(m) + ":");

        if (s < 10)
            answer += ("0" + String.valueOf(s));
        else
            answer += (String.valueOf(s));

        return answer;
    }
}