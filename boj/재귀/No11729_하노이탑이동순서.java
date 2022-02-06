import java.io.*;

public class Test {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());

        int ans=(int)Math.pow(2, n)-1;
        bw.write(ans+"\n");

        Hanoi(n, 1, 2, 3);

        bw.flush();
        bw.close();
    }

    private static void Hanoi(int n, int from, int mid, int to) throws IOException {

        if(n==1){
            bw.write(from + " " + to + "\n");
            return;
        }

        Hanoi(n-1, from, to, mid);

        bw.write(from + " " + to + "\n");

        Hanoi(n-1, mid, from, to);
    }
}
