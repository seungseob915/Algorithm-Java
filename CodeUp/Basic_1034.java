import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1034 {

	public static void main(String[] args) {

		// Scanner 클래스로는 10진수만 받을 수 있으므로, String wrapper로 형변환 하자
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		
		// valueOf : 해당 래퍼의 클래스로 변환시키는 역할
		System.out.println(Integer.valueOf(str, 8));
	}

}
