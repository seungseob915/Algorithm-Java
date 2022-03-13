import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int K=Integer.parseInt(stk.nextToken());
		int coin[]=new int[N];

		int ret=0;

		for(int i=0; i<N; i++){
			coin[i]=Integer.parseInt(br.readLine());
		}

		for(int i=N-1; i>=0; i--){
			ret+=(K/coin[i]);
			K=(K%coin[i]);
		}

		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
		br.close();
	}
}