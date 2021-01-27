import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Basic_1084 {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				String str="";
				for (int z = 0; z < c; z++) {
					str+=(i+" "+j+" "+z+"\n");
				}
				bf.write(str);
				bf.flush();
			}
		}
		System.out.println(a*b*c);
	}
}
