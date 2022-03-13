import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(stk.nextToken());
        int C=Integer.parseInt(stk.nextToken());
        int Q=Integer.parseInt(stk.nextToken());

        long pSum[][]=new long[R+1][C+1];

        for(int i=1; i<=R; i++){
            stk=new StringTokenizer(br.readLine());
            for(int j=1; j<=C; j++){
                int value = Integer.parseInt(stk.nextToken());
                pSum[i][j]=pSum[i-1][j]+pSum[i][j-1]-pSum[i-1][j-1]+value;
            }
        }


        for(int i=0; i<Q; i++){
            stk=new StringTokenizer(br.readLine());

            int x1=Integer.parseInt(stk.nextToken());
            int y1=Integer.parseInt(stk.nextToken());
            int x2=Integer.parseInt(stk.nextToken());
            int y2=Integer.parseInt(stk.nextToken());
            int bCnt=(x2-x1+1)*(y2-y1+1);
            long ret=(pSum[x2][y2]-pSum[x2][y1-1]-pSum[x1-1][y2]+pSum[x1-1][y1-1])/bCnt;
            bw.write(ret + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

