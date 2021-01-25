import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1027 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		StringTokenizer stk=new StringTokenizer(s, ".");
		int tcnt=stk.countTokens();
		
		String sarr[]=new String[3];
		
		for(int i=0; i<tcnt; i++) {
			sarr[i]=stk.nextToken();
		}
		System.out.printf("%02d-%02d-%04d", Integer.parseInt(sarr[2]), Integer.parseInt(sarr[1]), Integer.parseInt(sarr[0]));
	}

}
