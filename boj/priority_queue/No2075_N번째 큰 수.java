import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0; i<N; i++){
            StringTokenizer stk=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int nowVal=Integer.parseInt(stk.nextToken());

                if(pq.size()<N){
                    pq.add(nowVal);
                }
                else{
                    if(pq.peek()<nowVal){
                        pq.poll();
                        pq.add(nowVal);
                    }
                }
            }
        }

        bw.write(String.valueOf(pq.peek()));
        bw.flush();
        bw.close();
        br.close();
    }
}

