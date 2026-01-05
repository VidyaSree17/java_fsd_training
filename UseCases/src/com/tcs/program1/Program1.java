package com.tcs.program1;

import java.util.Scanner;

public class Program1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter SWIFT Code");
		String code = sc.next().toUpperCase();
		int len=code.length();
		boolean res3=false;
	
		if(len==8) {
			if(institutionValidation(code) && countryValidation(code) && locationValidation(code)) {
				System.out.println(code+" is VALID");
			}
		}
		
		else if(len==11){
			res3=branchValidation(code);
			if(institutionValidation(code) && countryValidation(code) && locationValidation(code) && res3) {
				System.out.println(code+" is VALID");
			}
		}
		
		else {
			System.out.println(code+" is INVALID");
			System.out.println("Invalid length");
		}
	}
	
	static boolean institutionValidation(String code) {
		for(int j=0;j<4;j++) {
			if(!Character.isAlphabetic(code.charAt(j))) {
				System.out.println("Institution Code must be alphabetic");
				return false;
			}
		}
		return true;
	}
	
	static boolean countryValidation(String code) {
		for(int j=4;j<6;j++) {
			if(!Character.isAlphabetic(code.charAt(j))) {
				System.out.println("Country code must be alphabetic");
				return false;
			}
		}
		return true;
	}
	
	static boolean locationValidation(String code) {
		for(int j=6;j<8;j++) {
			if(!Character.isLetterOrDigit(code.charAt(j))) {
				System.out.println("Location code contains invalid characters");
				return false;
			}
		}
		return true;
	}
	
	static boolean branchValidation(String code) {
		for(int j=8;j<11;j++) {
			if(!Character.isLetterOrDigit(code.charAt(j))) {
				System.out.println("Branch code contains invalid characters");
				return false;
			}
		}
		return true;
	}

}
