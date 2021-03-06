package org.lsong.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Takes a Long and returns the string words of the long. Class separates the
 * digits in groups of three beginning from the right.
 * E.G. 7725261 has 3 groups: [7][725][261].
 * Each group is an instance of NumberConverter. The NumberConverters are stored
 * in groupArray.
 * 
 * @author lsong
 */
public class NumberBuilder {

	private final long longNumber;
	// Stores NumberConverter
	private final List<NumberConverter> groupArray = new ArrayList<NumberConverter>();
	// Stores large number words e.g. "trillion"
	private final Map<Integer, String> wordMap = new HashMap<Integer, String>();//note: reference not changing
	private final boolean negative;//because set instructor

	//write a method that is static that getEnglish(). Can always access this method without the instance of the class
	public NumberBuilder(long longNumber) {
		if (longNumber < 0 ){// alt. (this.negative == true)
			this.negative = true;
		}
		else{
			this.negative = false;
		}
		this.longNumber = Math.abs(longNumber);
		addAllGroupsToArrayList();
		fillWordMap(wordMap);
	}
	
	public boolean isNegative(){//booleans don't use get() usually
		return negative;
	}

	/**
	 * Returns how many digits are the user's long
	 */
	public int getLengthOfLong() {
		return String.valueOf(longNumber).length();//conversions are expensive comparatively
	}

	/**
	 * Adds NumberConverter() based off of groups from the long Groups can only
	 * be a 3 digits long maximum
	 */
	public boolean addGroupToArrayList(int groupNumber) {
		try {
			NumberConverter group = new NumberConverter(groupNumber);
			return groupArray.add(group);
		} catch (IllegalArgumentException e) {//don't need to catch illegal argument exception. runtime excep.
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Counts how many groups of three can be formed by longNumber.
	 * E.G. 8208 forms 2 groups [8][208]
	 */
	//Note: should be private. make package better than public. shouldn't be public be
	//smarter about structuring testing
	public int getCountOfGroups() {

		int length = getLengthOfLong();

		if (length % 3 == 0) {
			return (getLengthOfLong() / 3);
		} else {
			return ((getLengthOfLong() / 3) + 1);//(getLengthOfLong() + (n-1))/3
		}
	}

	/**
	 * Returns the integers in the Nth group starting from the right.
	 * E.G. 64581 has groups [64][581]. N = 1 returns 581. N = 2 returns 64.
	 * Large numbers of 16+ digits lose preciseness due to rounding when
	 * finding the first group. If-Statement accounts for this.
	 */
	public int getNthGroup(int n) {
		if (n == 1) {//index start with zero TODO
			return (int) (longNumber % 1000);
		}
		return (int) ((longNumber / Math.pow(1000, n - 1)) % 1000);
	}

	/**
	 * Loops through each group, uses group's digits to make an instance of
	 * NumberConverter. Adds NumberConverter to groupArray. Returns array filled
	 * NumberConverter(group)
	 */
	private void addAllGroupsToArrayList() {
		for (int i = 1; i < (getCountOfGroups() + 1); i++) {//index start with zero TODO
			int groupNumber = getNthGroup(i);
			addGroupToArrayList(groupNumber);
		}
	}

	/**
	 * Fills hashmap with big number words in constructor. The integer index aligns
	 * with the index of the NumberConverters in groupArray.
	 * E.G. index 4 of numbers in groupArray are numbers in the trillions.
	 */
	private void fillWordMap(Map<Integer, String> wordMap) {
		wordMap.put(0, "");
		wordMap.put(1, " thousand");
		wordMap.put(2, " million");
		wordMap.put(3, " billion");
		wordMap.put(4, " trillion");
		wordMap.put(5, " quadrillion");
		wordMap.put(6, " quintillion");
	}

	/**
	 * Returns string of entire long. Loops through all the NumberConverter and
	 * concatenates them to one string. If number is negative, include "negative"
	 * at beginning of string. Loop results with a string that has an extra space
	 * at beginning and end that must be trimmed.
	 */
	@Override
	public String toString() {

		String numberStr = "";

		for (int i = 0; i < (getCountOfGroups()); i++) {
			//if (groupArray.get(i).toString().equals("")) {
			if (! groupArray.get(i).toString().isEmpty()){//only do if pass if trying to call out something special
				numberStr = " " + (groupArray.get(i) + wordMap.get(i))
						+ numberStr;
			}
		}
		//Can try to concatenate backwards. Or use append using String Builder TODO
		//Use the '+' if you only use it once. Don't use in for loops

		if (negative == true){
			numberStr = "negative" + numberStr;//Move to top. Start with Negative if applicable TODO
		}
		
		numberStr = numberStr.trim();
		if (numberStr.isEmpty()){
			return "Zero";
		}
		else{
			numberStr = numberStr.substring(0, 1).toUpperCase() + numberStr.substring(1);
		}
		return numberStr;
}

}
