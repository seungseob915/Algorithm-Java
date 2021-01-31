package kr.boj.ss;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ss_20055 {
	static int dur[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		dur=new int[2*n+1][2];
		
		for(int i=1; i<=2*n; i++) {
			dur[i][0]=scan.nextInt();
			dur[i][1]=0;
		}
		
		int step=0;
		
		while(true) {
			
			step++;
			//1. 벨트 이동
			int temp1=dur[2*n][0];	//2n칸 임시저장
			
			for(int i=2*n; i>=2; i--) {
				if (i == n + 1 || i==n) {
					dur[i][0] = dur[i - 1][0];
					dur[i][1] = 0;
					continue;
				}
				dur[i][0] = dur[i - 1][0];
				dur[i][1] = dur[i - 1][1];
			}
			dur[1][0] = temp1;
			dur[1][1] = 0;

			
			//2. 로봇 이동
			if(dur[n][1]==1) dur[n][1]=0;
			for(int i=n-1; i>=1; i--) {
				// 현재칸에 로봇이 없거나 다음칸의 내구도가 0이거나 로봇이 있을 때
				if(dur[i][1]==0) continue; 
				if(dur[i+1][0]==0 || dur[i+1][1]==1) continue;
				dur[i+1][0]--;
				dur[i+1][1]=1;
				dur[i][1]=0;
				if(i+1==n) {
					dur[n][1]=0;
				}
			}
			if (dur[1][0] > 0 && dur[1][1] == 0) {
				dur[1][0]--;
				dur[1][1]=1;
			}
			
			int fin_cnt=0;
			for(int i=1; i<=2*n; i++){
				if(dur[i][0]==0)
					fin_cnt++;
			}
			
			if(fin_cnt>=k) break;
		}
		System.out.println(step);
	}

}