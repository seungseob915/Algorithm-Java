package com.codeup;

import java.util.Scanner;

public class Basic_1045 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		System.out.println(x%y);
		System.out.printf("%.2f", (double)x/y);
	}

}
