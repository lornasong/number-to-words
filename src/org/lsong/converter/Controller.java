package org.lsong.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Calls NumberBuilder to convert user's long number into a string.
 * 
 * @author lsong
 */
public class Controller {

	public static void main(String[] args) {

		Controller controller = new Controller();

		controller.doMain();
	}

	private void doMain() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out
				.println("Please enter a number with a maximum of 19 digits:");
		long input = getLong(reader);
		NumberBuilder test = new NumberBuilder(input);
		System.out.println(test.toString());
		System.out.println("Thank you.");

	}

	/**
	 * Reads and returns user's long. Recursively calls itself if user input is
	 * incorrect.
	 */
	private long getLong(BufferedReader reader) {
		try {
			return Long.parseLong(reader.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Error: incorrect input");
			System.out
					.println("Please re-enter a number with the maximum of 19 digits:");
			return getLong(reader);
		} catch (IOException e) {
			System.out.println("Error occurred");
			e.printStackTrace();
		}
		return 0;
	}

}
