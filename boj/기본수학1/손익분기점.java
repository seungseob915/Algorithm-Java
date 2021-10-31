import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String input[]=br.readLine().split(" ");
        int sal=Integer.parseInt(input[1]);
        int ntb_price=Integer.parseInt(input[2]);
        int spend_money=Integer.parseInt(input[0]);
        int result=-1;

        if(ntb_price-sal!=0) {
            result = (spend_money / (ntb_price - sal))+1;
        }
        System.out.println(result<0?-1:result);
    }
}

