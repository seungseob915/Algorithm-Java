import java.io.*;
import java.util.StringTokenizer;

/*
       [BOJ] NO.10816  숫자 카드2

       ㅇ 계수 정렬

 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int card[] = new int[20000001];
		StringTokenizer stk = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			int num=Integer.parseInt(stk.nextToken());
			card[10000000+num]++;
		}

		int M = Integer.parseInt(br.readLine());
		stk=new StringTokenizer(br.readLine());

		for(int i=0; i<M; i++){
			bw.write(card[10000000+Integer.parseInt(stk.nextToken())]+" ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

