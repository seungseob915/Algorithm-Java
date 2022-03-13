import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N= Integer.parseInt(br.readLine());
        ArrayList<Integer> al=new ArrayList<>();
        boolean chk[]=new boolean[N+1];
        Arrays.fill(chk, true);
        chk[0]=chk[1]=false;

        for(int i=2; i<=N; i++){
            if(!chk[i])
                continue;

            for(int j=i*2; j<=N; j+=i){
                chk[j]=false;
            }

            al.add(i);
        }

        int sPoint=0;
        int ePoint=0;

        int sum=0;
        int cnt=0;

        while(true){
            if(sum>=N){
                sum-=al.get(sPoint++);
            }
            else if(ePoint==al.size())
                break;
            else sum+=al.get(ePoint++);

            if(sum==N) {
                cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}

