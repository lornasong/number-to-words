package org.lsong.converter;

/**
 * Takes a three digit (maximum) number to convert to a string. E.G. 203 returns
 * two hundred three, 641 returns six hundred twenty three Contains the
 * information on the string for each number
 * 
 * @author lornasong
 */
public class NumberConverter {

	private static int counter = 1;
	private int groupNumber;
	private final int groupCount;

	// TODO Need to specify that int can be maximum of three digits long
	public NumberConverter(int group) {
		this.groupNumber = group;
		groupCount = counter++;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public int getGroupCount() {
		return groupCount;
	}

	public int getNthDigit(int n) {
		return (int) ((groupNumber / Math.pow(10, n - 1)) % 10);
	}

	public String setOnesString() {
		int onesDigit = getNthDigit(1);

		switch (onesDigit) {

		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		}

		return "";
	}

	public String setTensString() {
		int tensDigit = getNthDigit(2);
		int onesDigit = getNthDigit(1);

		switch (tensDigit) {
		case 1:
			switch (onesDigit) {
			case 1:
				return "eleven";
			case 2:
				return "twelve";
			case 3:
				return "thirteen";
			case 4:
				return "fourteen";
			case 5:
				return "fifteen";
			case 6:
				return "sixteen";
			case 7:
				return "seventeen";
			case 8:
				return "eighteen";
			case 9:
				return "nineteen";
			}
			return "ten";
		case 2:
			return "twenty";
		case 3:
			return "thirty";
		case 4:
			return "forty";
		case 5:
			return "fifty";
		case 6:
			return "sixty";
		case 7:
			return "seventy";
		case 8:
			return "eighty";
		case 9:
			return "ninety";
		}

		return "";
	}
}
