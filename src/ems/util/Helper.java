package ems.util;

import java.util.Scanner;

public class Helper {
	
	public static int getI(){
		
		int val = 0;
		Scanner sc = new Scanner(System.in);
		boolean corectValue = false;

		do{

			try{
				val = sc.nextInt();
				corectValue = true;
				
			}
			catch(Exception e){
				getS(); 
				System.out.println("enter a valid integer");
			}

		} while(corectValue != true);
		
		return val;

	}
	public static String getS(){
		Scanner sc = new Scanner(System.in);
		String val = sc.next();
		return val;
	}


}
