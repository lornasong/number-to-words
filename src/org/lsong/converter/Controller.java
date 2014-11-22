package org.lsong.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		controller.doMain();
	}
	
	private void doMain(){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		
		System.out.println("Please enter a number with the maximum of 19 digits:");
		
		long input = getLong(reader);
		NumberBuilder test = new NumberBuilder(input);
		System.out.println(test.getCountOfGroups());


	}
	
	private long getLong(BufferedReader reader){
		try {
			return Long.parseLong(reader.readLine());
		} catch (IOException e) {
			System.out.println("Error occurred");
		}
		return 0;
	}

}
