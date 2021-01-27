import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Basic_1079 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		String s = bf.readLine(); //String
		String str[]=s.split(" ");
		int i=0;
		
		while(i<str.length) {
			System.out.println(str[i]);
			if(str[i].equals("q")) break;
			i++;
		}
	}
}
