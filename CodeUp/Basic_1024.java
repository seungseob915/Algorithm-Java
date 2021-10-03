import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1024 {

	public static void main(String[] args) {

		//방법 1. string 배열
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String [] sarr=str.split("");
		
		//방법 2. char 배열(charAt(i))
		// char[] arr_word=new char[word.length()];	// charAt 함수 사용
		// for(int i=0; i<arr_word.length; i++)
			// arr_word[i]=(word.charAt(i));
		
		//방법3. String 배열 + Character 클래스 활용 (split 미사용)
		// String [] arr=new String[word.length()];
		// for(int i=0; i<arr.length(); i++)
		//		arr[i]=Character.toString(word.charAt(i));
		
		
		for(int i=0; i<sarr.length; i++)
			System.out.printf("\'%s\'\n", sarr[i]);
	}

}
