package org.lsong.converter;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberConverterTest {

	@Test
	public void testGetOnesDigit() {
		NumberConverter test = new NumberConverter(295);
		assertEquals("Should have returned last digit", test.getNthDigit(1), 5);
	}

	@Test
	public void testGetTensDigit() {
		NumberConverter test = new NumberConverter(134);
		assertEquals("Should have returned second to last digit",
				test.getNthDigit(2), 3);
	}

	@Test
	public void testGetHundredsDigit() {
		NumberConverter test = new NumberConverter(201);
		assertEquals("Should have returned first digit", test.getNthDigit(2), 0);
	}

	@Test
	public void testGetDigitsNumberIsZero() {
		NumberConverter test = new NumberConverter(0);
		assertEquals("Should have returned ones digit as 0",
				test.getNthDigit(1), 0);
		assertEquals("Should have returned tens digit as 0",
				test.getNthDigit(2), 0);
		assertEquals("Should have returned hundreds digit as 0",
				test.getNthDigit(3), 0);
	}

	public void testGetDigitsNumberOnlyOnes() {
		NumberConverter test = new NumberConverter(9);
		assertEquals("Should have returned ones digit as 0",
				test.getNthDigit(1), 9);
		assertEquals("Should have returned tens digit as 0",
				test.getNthDigit(2), 0);
		assertEquals("Should have returned hundreds digit as 0",
				test.getNthDigit(3), 0);
	}

	@Test
	public void testOnesString() {
		NumberConverter zero = new NumberConverter(120);
		NumberConverter one = new NumberConverter(31);
		NumberConverter two = new NumberConverter(222);
		NumberConverter three = new NumberConverter(633);
		NumberConverter four = new NumberConverter(234);
		NumberConverter five = new NumberConverter(125);
		NumberConverter six = new NumberConverter(96);
		NumberConverter seven = new NumberConverter(737);
		NumberConverter eight = new NumberConverter(118);
		NumberConverter nine = new NumberConverter(9);
		assertEquals("Should have returned a ones string", one.setOnesString(),
				"one");
		assertEquals("Should have returned a ones string", two.setOnesString(),
				"two");
		assertEquals("Should have returned a ones string",
				three.setOnesString(), "three");
		assertEquals("Should have returned a ones string",
				four.setOnesString(), "four");
		assertEquals("Should have returned a ones string",
				five.setOnesString(), "five");
		assertEquals("Should have returned a ones string", six.setOnesString(),
				"six");
		assertEquals("Should have returned a ones string",
				seven.setOnesString(), "seven");
		assertEquals("Should have returned a ones string",
				eight.setOnesString(), "eight");
		assertEquals("Should have returned a ones string",
				nine.setOnesString(), "nine");
		assertEquals("Should have returned a ones string for one integer",
				zero.setOnesString(), "");
	}

	@Test
	public void testTensStringNotOne() {
		NumberConverter zero = new NumberConverter(503);
		NumberConverter two = new NumberConverter(521);
		NumberConverter three = new NumberConverter(231);
		NumberConverter four = new NumberConverter(849);
		NumberConverter five = new NumberConverter(950);
		NumberConverter six = new NumberConverter(361);
		NumberConverter seven = new NumberConverter(172);
		NumberConverter eight = new NumberConverter(980);
		NumberConverter nine = new NumberConverter(793);
		assertEquals("0Should have returned a tens string",
				zero.setTensString(), "");
		assertEquals("2Should have returned a tens string", two.setTensString(),
				"twenty");
		assertEquals("3Should have returned a tens string",
				three.setTensString(), "thirty");
		assertEquals("4Should have returned a tens string",
				four.setTensString(), "forty");
		assertEquals("5Should have returned a tens string",
				five.setTensString(), "fifty");
		assertEquals("6Should have returned a tens string", six.setTensString(),
				"sixty");
		assertEquals("7Should have returned a tens string",
				seven.setTensString(), "seventy");
		assertEquals("8Should have returned a tens string",
				eight.setTensString(), "eighty");
		assertEquals("9Should have returned a tens string",
				nine.setTensString(), "ninety");
	}
	
	public void testTensStringOne(){
		NumberConverter zero = new NumberConverter(810);
		NumberConverter one = new NumberConverter(211);
		NumberConverter two = new NumberConverter(912);
		NumberConverter three = new NumberConverter(13);
		NumberConverter four = new NumberConverter(714);
		NumberConverter five = new NumberConverter(915);
		NumberConverter six = new NumberConverter(116);
		NumberConverter seven = new NumberConverter(917);
		NumberConverter eight = new NumberConverter(218);
		NumberConverter nine = new NumberConverter(319);
		assertEquals("Should have returned tens string for 10",
				zero.setTensString(), "ten");
		assertEquals("Should have returned a tens string for 11", one.setTensString(),
				"eleven");
		assertEquals("Should have returned a tens string for 12", two.setTensString(),
				"twelve");
		assertEquals("Should have returned a tens string for 13",
				three.setTensString(), "thirteen");
		assertEquals("Should have returned a tens string for 14",
				four.setTensString(), "fourteen");
		assertEquals("Should have returned a tens string for 15",
				five.setTensString(), "fifteen");
		assertEquals("Should have returned a tens string for 16", six.setTensString(),
				"sixteen");
		assertEquals("Should have returned a tens string for 17",
				seven.setTensString(), "seventeen");
		assertEquals("8Should have returned a tens string for 18",
				eight.setTensString(), "eighteen");
		assertEquals("9Should have returned a tens string for 19",
				nine.setTensString(), "ninteen");
	}
}
