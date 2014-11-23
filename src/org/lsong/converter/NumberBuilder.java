package org.lsong.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberBuilder {

	private final long longNumber;
	private final List<NumberConverter> groupArray = new ArrayList<NumberConverter>();
	private Map<Integer, String> wordMap = new HashMap<Integer, String>();
	
	public NumberBuilder(long longNumber){
		this.longNumber = longNumber;
		addAllGroupsToArrayList();
		fillWordMap(wordMap);
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
	
	public int getNthGroup(int n) {
		return (int) ((longNumber / Math.pow(1000, n - 1)) % 1000);
	}
	
	public void addAllGroupsToArrayList(){	
		//Loop through the groups. Get group digits. Add to array
		for (int i = 1; i < (getCountOfGroups() + 1); i++){
			int groupNumber = getNthGroup(i);
			addGroupToArrayList(groupNumber);
		}
	}
	
	public void fillWordMap(Map<Integer, String>wordMap){
		wordMap.put(0, "");
		wordMap.put(1, " thousand");
		wordMap.put(2, " million");
		wordMap.put(3, " billion");
		wordMap.put(4, " trillion");
		wordMap.put(5, " quadrillion");
		wordMap.put(6, " quintillion");
	}
	
	@Override
	public String toString(){
		
		String numberStr = "";
		
		//for (int i = getCountOfGroups() - 1; i >-1; i--){
			
		
		
		for(int i = 0; i < (getCountOfGroups()); i++){
			if (groupArray.get(i).toString().equals("")){
			}
			else{
				numberStr = " " + (groupArray.get(i) + wordMap.get(i)) + numberStr;
			}
		}
		
		numberStr = numberStr.trim();
		return numberStr;
	}
	
}
