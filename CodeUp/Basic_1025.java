import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic_1025 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		String [] sp=s.split("");
		
		for(int i=0; i<sp.length; i++) {
			System.out.printf("[%d]\n", Integer.parseInt(sp[i])*(int)Math.pow(10, sp.length-i-1));
		}
	}

}
