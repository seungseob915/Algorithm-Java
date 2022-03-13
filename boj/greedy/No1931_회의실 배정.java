import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Meeting implements Comparable<Meeting>{
		private long st, et;

		public Meeting(long st, long et) {
			this.st = st;
			this.et = et;
		}

		public long getSt() {
			return st;
		}

		public long getEt() {
			return et;
		}


		@Override
		public int compareTo(Meeting o) {
			if(this.et - o.et > 0){
				return 1;
			}
			else{
				if(this.et == o.et){
					return this.st - o.st > 0 ? 1 : -1;
				}
				return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int N=Integer.parseInt(br.readLine());
		Meeting meeting[]=new Meeting[N];

		for(int i=0; i<N; i++){
			StringTokenizer stk=new StringTokenizer(br.readLine());
			long st=Long.parseLong(stk.nextToken());
			long et=Long.parseLong(stk.nextToken());

			meeting[i]=new Meeting(st, et);
		}

		Arrays.sort(meeting);

		long nowEt=-1;
		int cnt=0;

		for(int i=0; i<N; i++){
			if(nowEt>meeting[i].getSt()){
				continue;
			}
			cnt++;
			nowEt=meeting[i].getEt();
		}


		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}