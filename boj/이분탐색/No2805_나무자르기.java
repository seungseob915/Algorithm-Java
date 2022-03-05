import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stk.nextToken());
        long M=Long.parseLong(stk.nextToken());

        long tree[]=new long[N];

        stk=new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            tree[i]=Long.parseLong(stk.nextToken());
        }

        int lo=0;
        int hi=1000000000;

        while(lo+1<hi){
            int mid=(lo+hi)/2;

            long tsum=0;

            for(int i=0; i<N; i++){
                if(tree[i]<mid)
                    continue;
                tsum+=(tree[i]-mid);
            }

            if(tsum>=M)
                lo=mid;
            else
                hi=mid;
        }

        bw.write(String.valueOf(lo));
        bw.flush();
        bw.close();
        br.close();
    }
}
