import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1026 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		StringTokenizer stk=new StringTokenizer(s, ":");
		int tcnt=stk.countTokens();
		
		String sarr[]=new String[3];
		
		for(int i=0; i<tcnt; i++) {
			sarr[i]=stk.nextToken();
		}
		System.out.println(Integer.parseInt(sarr[1]));
	}

}
