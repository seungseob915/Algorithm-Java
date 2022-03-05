import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Room{
        int t;
        int a;
        int h;

        public Room(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stk.nextToken());
        long hAtk=Long.parseLong(stk.nextToken());

        Room room[]=new Room[N];

        for(int i=0; i<N; i++){
            stk=new StringTokenizer(br.readLine());
            int tt=Integer.parseInt(stk.nextToken());
            int ta=Integer.parseInt(stk.nextToken());
            int th=Integer.parseInt(stk.nextToken());
            room[i]=new Room(tt, ta, th);
        }

        long lo=1;
        long hi=Long.MAX_VALUE;

        while(lo<=hi) {
            long mid=(lo/2)+(hi/2); // (lo+hi) / 2 를 하면 오버플로우 발생
            // true
            if(simulate(mid, hAtk, room)) {
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }

        bw.write(String.valueOf(lo));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean simulate(long hp, long hAtk, Room[] room) {
        long nowHP=hp;
        long nowAtk=hAtk;
        int step = 0;
        int fStep= room.length;

        while (step < fStep) {

            if(room[step].t==1) {
                long monsterHP = room[step].h;
                long monDeathCnt=monsterHP/nowAtk;
                if(monsterHP%nowAtk>0)
                    monDeathCnt++;

                long warrDeathCnt=nowHP/room[step].a;
                if(nowHP%room[step].a>0)
                    warrDeathCnt++;

                if(warrDeathCnt<monDeathCnt){
                    return false;
                }

                nowHP -= (monDeathCnt-1)*room[step].a;

                // 전투 과정을 모듈러 연산을 통해 구현(시간 단축)
                /*
                while(true) {

                    // 1. 용사 선공격빵. 몬스터 체력 깎임.
                    monsterHP -= nowAtk;

                    // 1-1. 몬스터 생명력이 0이면 전투 종료 후, 다른방 이동
                    if (monsterHP <= 0)
                        break;

                    // 2. 몬스터 공격. 용사 체력 깎임
                    nowHP -= room[step].a;

                    // 2-1. 용사의 체력이 0인경우 종료
                    if(nowHP <= 0) {
                        return false;
                    }
                }
                 */
            }
            else{
                nowAtk+=room[step].a;
                nowHP+=room[step].h;
                if(nowHP>hp)
                    nowHP=hp;
            }

            step++;
        }
        return true;
    }
}
