package com.codeup;

import java.util.Scanner;

public class Basic_1055 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		int y=scan.nextInt();
		boolean xx=false,yy=false;
		if(x==1) xx=true;
		if(y==1) yy=true;
		
		System.out.println(xx||yy==true ? 1 : 0);
	}

}
