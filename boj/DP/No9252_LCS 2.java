import java.io.*;

/*
       [BOJ] NO.9252  LCS 2

       ㅇ 2차원 배열로 A[i]=B[j] 를 누적 카운트 해간다.
       ㅇ A[i] = b[j]가 같은 경우, sum[i][j]=sum[i-1][j-1]+1
       ㅇ 다른 경우, sum[i][j]=max(sum[i-1][j], sum[i][j-1])
       ㅇ LCS는 배열 맨 끝 지점에서, 역으로 추적하면서 sum[i][j]=sum[i-1][j-1]+1 인 경우, a[i]=b[j] 일 때를 체크한다.


 */

public class Main {
    static  String a, b;
    static int sum[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        a=br.readLine();
        b=br.readLine();

        sum=new int[a.length()+1][b.length()+1];

        // 1. LCS 길이 누적 계산
        for(int i=0; i<a.length(); i++){
            for(int j=0; j<b.length(); j++){
                if(a.charAt(i)==b.charAt(j)){
                    sum[i+1][j+1]=sum[i][j]+1;
                }
                else{
                    sum[i+1][j+1]=Math.max(sum[i][j+1], sum[i+1][j]);
                }
            }
        }

        bw.write(sum[a.length()][b.length()]+"\n");

        // 2. LCS 문자열
        if(sum[a.length()][b.length()]!=0){
            bw.write(findLCS(a.length(), b.length()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String findLCS(int h, int w) {
        if(h==0 || w==0){
            return "";
        }
        if(a.charAt(h-1) == b.charAt(w-1)){
            return findLCS(h-1, w-1) + a.charAt(h-1);
        }

        if(sum[h-1][w] >= sum[h][w-1]){
            return findLCS(h-1, w);
        }
        return findLCS(h, w-1);
    }
}

