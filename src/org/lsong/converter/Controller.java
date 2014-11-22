package org.lsong.converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		
		System.out.println("Please enter a number with the maximum of 12 digits:");
		
		NumberConverter test = new NumberConverter(321);
		System.out.println(test.toString());

	}

}
