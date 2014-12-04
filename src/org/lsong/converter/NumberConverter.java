package org.lsong.converter;

/**
 * Takes a three digit (maximum) number to convert to a string. E.G. 203 returns
 * two hundred and three, 641 returns six hundred and twenty three. Contains the
 * information on the string for each number.
 * 
 * @author lornasong
 */
public class NumberConverter {

	private final int groupNumber;

	public NumberConverter(int group) {
		if (String.valueOf(group).length() > 3) {
			throw new IllegalArgumentException(
					"Number must be under three digits");
		}
		this.groupNumber = group;
	}

	/**
	 * Returns the digit in the position requested (the Nth digit).
	 * E.G. for 745, the 3rd digit returned is 7, the 2nd digit is 4, so on.
	 */
	public int getNthDigit(int n) {
		return (int) ((groupNumber / Math.pow(10, n - 1)) % 10);
	}

	/**
	 * Returns the string of the Nth digit from right.
	 * N = 3 for digit in hundreds place value.
	 * N = 2 for digit in tens place value.
	 * N = 1 for digit in ones place value.
	 * This method is called for finding the string of the 1st and 3rd digit.
	 */
	private String getOneNumberToString(int placeValue) {
		int digit = getNthDigit(placeValue);

		switch (digit) {

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

		// case of zero
		return "";
	}

	/**
	 * Returns the string for the ones place value depending on tens place value.
	 * If tens place value = 1, then return "" empty string for ones place value.
	 * This is because, if tens place value = 1, the string information of the ones
	 * place value is contained in the tens string.
	 * E.G. 618 returns "" because the 8 is in the tens place value, "eighteen"
	 */
	public String setOnesString() {
		if (getNthDigit(2) == 1) {
			return "";
		} else {
			return getOneNumberToString(1);
		}
	}

	/**
	 * Returns the string of the second digit as a tens place value.
	 * E.G. 283 returns "eighty."
	 * Special case of 1 in tens place. If 1 is in the tens place, method
	 * looks at ones place value and returns strings "ten" to "nineteen."
	 * E.G. 412 returns "twelve." Returns an empty string if the
	 * tens place value is empty.
	 */
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

	/**
	 * Returns string of the third digit.
	 * Gets 3rd digit string and concatenates " hundred"
	 * @return
	 */
	public String setHundredsString() {

		if (getOneNumberToString(3).equals("")) {
			return "";
		} else {
			return (getOneNumberToString(3) + " hundred");
		}
	}

	/**
	 * Returns the full string of groupNumber.
	 * Concatenates hundreds, tens, and ones strings.
	 */
	@Override
	public String toString() {

		if (setHundredsString().equals("")) {
			if (setTensString().equals("")) {
				if (setOnesString().equals("")) {
					return "";//H, T, Os are all empty
				} else {
					return setOnesString();//H, Ts are empty
				}
			} else {
				if (setOnesString().equals("")) {
					return setTensString();//H, Os are empty
				}
				return setTensString() + " " + setOnesString();
			}
		} else {
			if (setTensString().equals("")) {
				if (setOnesString().equals("")) {
					return setHundredsString();//T, Os are empty
				}
				return setHundredsString() + " and " + setOnesString();//Ts are empty
			} else {
			}
			if (setOnesString().equals("")) {
				return setHundredsString() + " and " + setTensString();//Os are empty
			} else {
				return setHundredsString() + " and " + setTensString() + " "
						+ setOnesString();//Nothing is empty
			}
		}

	}

}
