package org.lsong.converter;

import java.util.ArrayList;
import java.util.List;

public class NumberBuilder {

	private final long longNumber;
	private final List<NumberConverter> groupArray = new ArrayList<NumberConverter>();
	
	public NumberBuilder(long longNumber){
		this.longNumber = longNumber;
	}
	
	public long getLongNumber(){
		return longNumber;
	}
	
	public List<NumberConverter> getGroupArray(){
		return groupArray;
	}
	
	public int getLengthOfLong(){
		return String.valueOf(longNumber).length();
	}
	
	public boolean addGroupToArrayList(int groupNumber){
		NumberConverter group = new NumberConverter(groupNumber);
		return groupArray.add(group);
	}
	
	public int getCountOfGroups(){
		
		int length = getLengthOfLong();
		
		if (length % 3 == 0){
			return (getLengthOfLong() / 3);
		}
		else{
			return ((getLengthOfLong() / 3) + 1);
		}
	}
	
}
