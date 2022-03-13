import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(stk.nextToken());
        int S=Integer.parseInt(stk.nextToken());

        int num[]=new int[N];

        stk=new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            num[i]=Integer.parseInt(stk.nextToken());
        }

        int sIdx=0;
        int eIdx=0;
        int shortLen=987654321;
        long sum=0;

        while(true){
            if(sum>=S){
                sum-=num[sIdx++];
            }
            else if(eIdx==N){
                break;
            }
            else{
                sum+=num[eIdx++];
            }

            if(sum>=S){
                shortLen=Math.min(shortLen, eIdx-sIdx);
            }
        }

        bw.write(String.valueOf(shortLen==987654321?0:shortLen));
        bw.flush();
        bw.close();
        br.close();
    }
}

