package org.lsong.converter;

public class Controller {

	public static void main(String[] args) {
		NumberConverter test = new NumberConverter(310);
		System.out.println(test.getNthDigit(1));
		System.out.println(test.setOnesString());
		System.out.println(test.getNthDigit(1));
		System.out.println(test.setTensString());

	}

}
