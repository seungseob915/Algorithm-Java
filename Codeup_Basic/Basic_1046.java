package com.codeup;

import java.util.Scanner;

public class Basic_1046 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		int z=scan.nextInt();
		
		System.out.println(x+y+z);
		System.out.printf("%.1f",(x+y+z)/3.0);
	}

}
