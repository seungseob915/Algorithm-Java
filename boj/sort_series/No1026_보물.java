import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
       [BOJ] NO.1024  보물

       ㅇ A, B 정렬 후, 서로 크로스해서 곱하면 최소가 된다.

 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int a[]=new int[N];
		int b[]=new int[N];

		StringTokenizer stk1=new StringTokenizer(br.readLine());
		StringTokenizer stk2=new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			a[i]=Integer.parseInt(stk1.nextToken());
			b[i]=Integer.parseInt(stk2.nextToken());
		}

		Arrays.sort(a);
		Arrays.sort(b);

		int ans=0;

		for(int i=0; i<N; i++){
			ans+=a[i]*b[N-1-i];
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
}

