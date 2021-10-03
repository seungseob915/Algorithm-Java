import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1023 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String s[]=str.split("\\.");
		System.out.printf("%d\n%d", Integer.parseInt(s[0]), Integer.parseInt(s[1]));

	}

}
