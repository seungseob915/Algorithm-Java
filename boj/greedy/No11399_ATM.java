import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
       [BOJ] NO.11399  ATM

       ㅇ 시간이 가장 적은 사람부터 먼저 처리

 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int p[]=new int[N+1];

		StringTokenizer stk=new StringTokenizer(br.readLine());

		for(int i=1; i<=N; i++){
			p[i]=Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(p);
		int ans=0;

		for(int i=1; i<=N; i++){
			ans+=p[i]*(N-i+1);
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
}

