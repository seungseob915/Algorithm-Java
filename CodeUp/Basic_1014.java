import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1014 {

	public static void main(String[] args) throws IOException {
		
		// 문자열 토큰으로 구분하기
//		String str;
//		Scanner scan=new Scanner(System.in);
//		str=scan.nextLine();
//		
//		StringTokenizer st=new StringTokenizer(str, " ");
//		int cnt=st.countTokens();
//		for(int i=0; i<cnt; i++) {
//			String token=st.nextToken();
//			System.out.println(token);
		
		// 버퍼리더 사용(1byte씩 받을수 있도록. 기존 버퍼리더는 2byte씩 받지만, inputstreamreader을 포함하면 1byte 처리가능)
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		String[] ans=s.split(" ");
		System.out.println(ans[1] + " " + ans[0]);
		
	}

}
