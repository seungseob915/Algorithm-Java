package com.codeup;

import java.util.Scanner;

public class Basic_1048 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		
		System.out.println(x*(1<<y));
	}

}
