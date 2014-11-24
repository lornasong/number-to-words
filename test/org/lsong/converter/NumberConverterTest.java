package org.lsong.converter;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests NumberConverters ability to grab digits of certain place values and
 * return the string
 * 
 * @author lornasong
 */
public class NumberConverterTest {
		
	/**
	 * Next Three Test: retrieves number at place values ones, tens, hundreds
	 * Each method tests (at least) a regular number, a number that has 0 in the
	 * place value, a number that ends between 11-19.
	 */
	@Test
	public void testGetOnesDigit() {
		NumberConverter test5 = new NumberConverter(295);
		NumberConverter test9 = new NumberConverter(109);
		NumberConverter test11 = new NumberConverter(311);
		NumberConverter test0 = new NumberConverter(310);
		NumberConverter test00 = new NumberConverter(2);
		assertEquals("Should have returned last digit", test5.getNthDigit(1), 5);
		assertEquals("Should have returned last digit", test9.getNthDigit(1), 9);
		assertEquals("Should have returned last digit", test11.getNthDigit(1),
				1);
		assertEquals("Should have returned last digit", test0.getNthDigit(1), 0);
		assertEquals("Should have returned last digit", test00.getNthDigit(1),
				2);
	}

	@Test
	public void testGetTensDigit() {
		NumberConverter test2 = new NumberConverter(295);
		NumberConverter test0 = new NumberConverter(109);
		NumberConverter test13 = new NumberConverter(313);
		assertEquals("Should have returned second to last digit",
				test2.getNthDigit(2), 9);
		assertEquals("Should have returned second to last digit",
				test0.getNthDigit(2), 0);
		assertEquals("Should have returned second to last digit",
				test13.getNthDigit(2), 1);
	}

	@Test
	public void testGetHundredsDigit() {
		NumberConverter test5 = new NumberConverter(593);
		NumberConverter test0 = new NumberConverter(21);
		NumberConverter test16 = new NumberConverter(416);
		assertEquals("Should have returned first digit", test5.getNthDigit(3),
				5);
		assertEquals("Should have returned first digit", test0.getNthDigit(3),
				0);
		assertEquals("Should have returned first digit", test16.getNthDigit(3),
				4);
	}

	/**
	 * Tests a case of retrieving digits from the number 0
	 */
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

	/**
	 * Test that returned string is word of ones place digit. Tests cases that
	 * tens place is not one because then ones place digit is empty string E.G.
	 * 313 - tens digit is one. Ones place string should not be "three", it
	 * should be "". This is because tens place string will be "thirteen"
	 */
	@Test
	public void testsetOnesString() {
		NumberConverter zero = new NumberConverter(120);
		NumberConverter one = new NumberConverter(31);
		NumberConverter two = new NumberConverter(222);
		NumberConverter three = new NumberConverter(633);
		NumberConverter four = new NumberConverter(234);
		NumberConverter five = new NumberConverter(125);
		NumberConverter six = new NumberConverter(96);
		NumberConverter seven = new NumberConverter(737);
		NumberConverter eight = new NumberConverter(108);
		NumberConverter nine = new NumberConverter(9);
		NumberConverter teen = new NumberConverter(712);
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
		assertEquals("Should have returned a ones string",
				zero.setOnesString(), "");
		assertEquals("Should have returned a ones string",
				teen.setOnesString(), "");
	}

	/**
	 * Tests for numbers that do not have a one in the tens place.
	 */
	@Test
	public void testsetTensStringNotOne() {
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
		assertEquals("2Should have returned a tens string",
				two.setTensString(), "twenty");
		assertEquals("3Should have returned a tens string",
				three.setTensString(), "thirty");
		assertEquals("4Should have returned a tens string",
				four.setTensString(), "forty");
		assertEquals("5Should have returned a tens string",
				five.setTensString(), "fifty");
		assertEquals("6Should have returned a tens string",
				six.setTensString(), "sixty");
		assertEquals("7Should have returned a tens string",
				seven.setTensString(), "seventy");
		assertEquals("8Should have returned a tens string",
				eight.setTensString(), "eighty");
		assertEquals("9Should have returned a tens string",
				nine.setTensString(), "ninety");
	}

	/**
	 * Tests numbers that have one in tens place value. E.G. Explicitly tests
	 * 'ten' through 'nineteen'
	 */
	@Test
	public void testSetTensStringOne() {
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
		assertEquals("Should have returned a tens string for 11",
				one.setTensString(), "eleven");
		assertEquals("Should have returned a tens string for 12",
				two.setTensString(), "twelve");
		assertEquals("Should have returned a tens string for 13",
				three.setTensString(), "thirteen");
		assertEquals("Should have returned a tens string for 14",
				four.setTensString(), "fourteen");
		assertEquals("Should have returned a tens string for 15",
				five.setTensString(), "fifteen");
		assertEquals("Should have returned a tens string for 16",
				six.setTensString(), "sixteen");
		assertEquals("Should have returned a tens string for 17",
				seven.setTensString(), "seventeen");
		assertEquals("Should have returned a tens string for 18",
				eight.setTensString(), "eighteen");
		assertEquals("Should have returned a tens string for 19",
				nine.setTensString(), "nineteen");
	}

	/**
	 * Tests hundreds string.
	 */
	@Test
	public void testSetHundredsString() {
		NumberConverter zero = new NumberConverter(12);
		NumberConverter one = new NumberConverter(182);
		NumberConverter two = new NumberConverter(284);
		NumberConverter three = new NumberConverter(318);
		NumberConverter four = new NumberConverter(436);
		NumberConverter five = new NumberConverter(563);
		NumberConverter six = new NumberConverter(601);
		NumberConverter seven = new NumberConverter(739);
		NumberConverter eight = new NumberConverter(897);
		NumberConverter nine = new NumberConverter(912);

		assertEquals("Should have returned strings for hundreds",
				zero.setHundredsString(), "");
		assertEquals("Should have returned strings for hundreds",
				one.setHundredsString(), "one hundred");
		assertEquals("Should have returned strings for hundreds",
				two.setHundredsString(), "two hundred");
		assertEquals("Should have returned strings for hundreds",
				three.setHundredsString(), "three hundred");
		assertEquals("Should have returned strings for hundreds",
				four.setHundredsString(), "four hundred");
		assertEquals("Should have returned strings for hundreds",
				five.setHundredsString(), "five hundred");
		assertEquals("Should have returned strings for hundreds",
				six.setHundredsString(), "six hundred");
		assertEquals("Should have returned strings for hundreds",
				seven.setHundredsString(), "seven hundred");
		assertEquals("Should have returned strings for hundreds",
				eight.setHundredsString(), "eight hundred");
		assertEquals("Should have returned strings for hundreds",
				nine.setHundredsString(), "nine hundred");
	}

	/**
	 * Tests the string for all three digits combined. Tests all possible
	 * combinations of place values with zero.
	 */
	@Test
	public void testToString() {
		NumberConverter test = new NumberConverter(436);
		NumberConverter testH = new NumberConverter(95);
		NumberConverter testT = new NumberConverter(203);
		NumberConverter testO = new NumberConverter(870);
		NumberConverter testHT = new NumberConverter(2);
		NumberConverter testHO = new NumberConverter(40);
		NumberConverter testTO = new NumberConverter(900);
		NumberConverter testHTO = new NumberConverter(013);
		assertEquals("Should have had stringed together correctly",
				test.toString(), "four hundred and thirty six");
		assertEquals("Should have had stringed together correctly",
				testH.toString(), "ninety five");
		assertEquals("Should have had stringed together correctly",
				testT.toString(), "two hundred and three");
		assertEquals("Should have had stringed together correctly",
				testO.toString(), "eight hundred and seventy");
		assertEquals("Should have had stringed together correctly",
				testHT.toString(), "two");
		assertEquals("Should have had stringed together correctly",
				testHO.toString(), "forty");
		assertEquals("Should have had stringed together correctly",
				testTO.toString(), "nine hundred");
		assertEquals("Should have had stringed together correctly",
				testHTO.toString(), "");

	}
}
