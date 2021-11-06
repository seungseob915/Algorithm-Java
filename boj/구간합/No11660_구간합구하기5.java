import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        int[][] num=new int[Integer.parseInt(input[0])+1][Integer.parseInt(input[0])+1];
        int[][] prefix_sum=new int[Integer.parseInt(input[0])+1][Integer.parseInt(input[0])+1];
        int cnt=Integer.parseInt(input[1]);

        for(int i=1; i<num.length; i++) {
            input=br.readLine().split(" ");
            for (int j = 1; j < num[0].length; j++) {
                num[i][j] = Integer.parseInt(input[j-1]);
                if(i==1 && j==1)
                    prefix_sum[i][j] = num[i][j];
                else
                    prefix_sum[i][j] = prefix_sum[i-1][j]+prefix_sum[i][j-1]+num[i][j]-prefix_sum[i-1][j-1];
            }
        }

        for(int i=0; i<cnt; i++){
            input=br.readLine().split(" ");
            int start_x=Integer.parseInt(input[0]);
            int start_y=Integer.parseInt(input[1]);
            int end_x=Integer.parseInt(input[2]);
            int end_y=Integer.parseInt(input[3]);

            bw.write(String.valueOf(prefix_sum[end_x][end_y]-prefix_sum[start_x-1][end_y]-prefix_sum[end_x][start_y-1]+prefix_sum[start_x-1][start_y-1])+"\n");
        }
        bw.flush();
        bw.close();
    }

}

