import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int input=Integer.parseInt(br.readLine());

        board=new char[input+1][input+1];
        for(int i=1; i<input+1; i++)
            Arrays.fill(board[i], ' ');

        div(1, 1, input);

        for(int i=1; i<input+1; i++){
            for(int j=1; j<input+1; j++){
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void div(int sx, int sy, int size){
        if(size==1){
            board[sx][sy]='*';
            return;
        }

        int nsize=size/3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1)
                    continue;
                div(sx+i*nsize, sy+j*nsize, nsize);
            }
        }
    }

}