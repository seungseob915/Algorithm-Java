import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        int prevSum[][]=new int[3][2];  // 0: MAX / 1 : MIN
        int nowSum[][]=new int[3][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk=new StringTokenizer(br.readLine());
            int left= Integer.parseInt(stk.nextToken());
            int mid= Integer.parseInt(stk.nextToken());
            int right= Integer.parseInt(stk.nextToken());

            nowSum[0][0]=Math.max(prevSum[0][0], prevSum[1][0])+left;
            nowSum[0][1]=Math.min(prevSum[0][1], prevSum[1][1])+left;
            nowSum[1][0] = Math.max(Math.max(prevSum[0][0], prevSum[1][0]), prevSum[2][0]) + mid;
            nowSum[1][1] = Math.min(Math.min(prevSum[0][1], prevSum[1][1]), prevSum[2][1]) + mid;
            nowSum[2][0]=Math.max(prevSum[1][0], prevSum[2][0])+right;
            nowSum[2][1]=Math.min(prevSum[1][1], prevSum[2][1])+right;

            prevSum[0][0]=nowSum[0][0];
            prevSum[0][1]=nowSum[0][1];
            prevSum[1][0]=nowSum[1][0];
            prevSum[1][1]=nowSum[1][1];
            prevSum[2][0]=nowSum[2][0];
            prevSum[2][1]=nowSum[2][1];
        }
        int maxVal=Math.max(Math.max(prevSum[0][0], prevSum[1][0]), prevSum[2][0]);
        int minVal=Math.min(Math.min(prevSum[0][1], prevSum[1][1]), prevSum[2][1]);
        bw.write(maxVal + " " + minVal);
        bw.flush();
        bw.close();
        br.close();
    }
}

