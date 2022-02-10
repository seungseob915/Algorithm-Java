import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] consent;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(stk.nextToken());
		int m=Integer.parseInt(stk.nextToken());

		stk=new StringTokenizer(br.readLine());
		int[] board=new int[n];
		consent=new int[m];

		for(int i=0; i<n; i++)
			board[i]=Integer.parseInt(stk.nextToken());

		Arrays.sort(board);
		int nowIdx=n-1;
		int nowTime=0;

		while(true){
			// 1. 콘센트에 플러그 꽂기
			// 남은 플러그 존재시
			if(nowIdx!=-1) {
				for (int i = 0; i < m; i++) {
					if (consent[i] == 0 && nowIdx!=-1) {
						consent[i] = board[nowIdx--];
					}
				}
			}

			// 콘센트 꽂혀있는 대상 중, 가장 적은시간 소모되는 것 추출 후
			int leastTime=987654321;

			for(int i=0; i<m; i++){
				if(consent[i]!=0)
					leastTime=Math.min(leastTime, consent[i]);
			}

			// 다 0이면, break
			if(leastTime==987654321)
				break;

			// 최소시간 동시 마이너스
			for(int i=0; i<m; i++){
				if(consent[i]!=0) {
					consent[i] -= leastTime;

					if(consent[i]==0 && nowIdx != -1){
						consent[i]=board[nowIdx--];
					}
				}
			}
			nowTime+=leastTime;
		}

		bw.write(String.valueOf(nowTime));
		bw.flush();
		bw.close();
		br.close();
	}

}
