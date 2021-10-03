import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1019 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String s[]=str.split("\\.");	// 특수문자 \\ 처리
		
		System.out.printf("%04d.%02d.%02d", Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));

	}

}
