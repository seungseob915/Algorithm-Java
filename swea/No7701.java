import java.io.*;
import java.util.*;

public class Test {
	static int T;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		T=Integer.parseInt(br.readLine());
		int cnt=1;

		while(cnt<=T){
			int wordCnt=Integer.parseInt(br.readLine());

			HashSet<String> set=new HashSet<>();

			for(int i=0; i<wordCnt; i++){
				set.add(br.readLine());
			}

			List<String> list=new ArrayList<>(set);
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length()==o2.length())
						return o1.compareTo(o2);
					else
						return o1.length() - o2.length();

				}
			});
			bw.write("#"+cnt+"\n");
			for(int i=0; i<list.size(); i++)
				bw.write(list.get(i)+"\n");

			cnt++;
		}
		bw.flush();

		br.close();
		bw.close();
	}
}
