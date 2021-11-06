import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        int[] num=new int[Integer.parseInt(input[0])];
        int[] prefix_sum=new int[Integer.parseInt(input[0])];
        int cnt=Integer.parseInt(input[1]);

        input=br.readLine().split(" ");
        for(int i=0; i<num.length; i++) {
            num[i] = Integer.parseInt(input[i]);
            if(i==0)
                prefix_sum[i]=num[i]+0;
            else
                prefix_sum[i]=num[i]+prefix_sum[i-1];
        }

        for(int i=0; i<cnt; i++){
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0])-1;
            int end=Integer.parseInt(input[1])-1;

            if(start==0)
                bw.write(String.valueOf(prefix_sum[end])+"\n");
            else
                bw.write(String.valueOf(prefix_sum[end]-prefix_sum[start-1])+"\n");
        }
        bw.flush();
        bw.close();
    }

}