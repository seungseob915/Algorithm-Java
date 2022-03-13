import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int L= Integer.parseInt(stk.nextToken());
		int board[]=new int[N];

		stk=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			board[i]=Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(board);

		int cnt = 1;
		int nIdx=0;
		int eNum=board[0]+L-1;
		int finNum=board[N-1];

		while(eNum<finNum){
			if(board[nIdx]<=eNum){
				nIdx++;
			}
			else {
				eNum = board[nIdx]+L-1;
				cnt++;
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}