import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        int pSum[] = new int[N+1];

        StringTokenizer stk=new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            pSum[i]=Integer.parseInt(stk.nextToken());
            pSum[i]+=pSum[i-1];
        }

        int M=Integer.parseInt(br.readLine());

        while(M>0){
            stk=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(stk.nextToken());
            int b=Integer.parseInt(stk.nextToken());
            bw.write(String.valueOf(pSum[b]-pSum[a-1])+"\n");
            M--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}