package org.lsong.converter;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberBuilderTest {

	@Test
	public void testGetLength() {
		NumberBuilder test0 = new NumberBuilder(0);
		NumberBuilder test1 = new NumberBuilder(1);
		NumberBuilder test8 = new NumberBuilder(28747474);
		NumberBuilder test19 = new NumberBuilder(1234567890123456789L);
		assertEquals(test0.getLengthOfLong(), 1);
		assertEquals(test1.getLengthOfLong(), 1);
		assertEquals(test8.getLengthOfLong(), 8);
		assertEquals(test19.getLengthOfLong(), 19);
	}

	@Test
	public void testAddGroupToArrayList() {
		NumberBuilder test = new NumberBuilder(123456);
		assertTrue(test.addGroupToArrayList(456));
		assertTrue(test.addGroupToArrayList(123));
	}

	@Test
	public void testGetCountOfGroups() {
		NumberBuilder test1a = new NumberBuilder(0);
		NumberBuilder test1b = new NumberBuilder(4);
		NumberBuilder test1c = new NumberBuilder(52);
		NumberBuilder test1d = new NumberBuilder(123);
		NumberBuilder test2a = new NumberBuilder(7650);
		NumberBuilder test2b = new NumberBuilder(123999);
		NumberBuilder test7 = new NumberBuilder(1234567890123456789L);
		assertEquals(test1a.getCountOfGroups(), 1);
		assertEquals(test1b.getCountOfGroups(), 1);
		assertEquals(test1c.getCountOfGroups(), 1);
		assertEquals(test1d.getCountOfGroups(), 1);
		assertEquals(test2a.getCountOfGroups(), 2);
		assertEquals(test2b.getCountOfGroups(), 2);
		assertEquals(test7.getCountOfGroups(), 7);
	}

	@Test
	public void testGetNthGroup() {
		NumberBuilder group1 = new NumberBuilder(123);
		assertEquals(group1.getNthGroup(1), 123);
		assertEquals(group1.getNthGroup(2), 0);
		assertEquals(group1.getNthGroup(3), 0);

		NumberBuilder group2 = new NumberBuilder(123456);
		assertEquals(group2.getNthGroup(1), 456);
		assertEquals(group2.getNthGroup(2), 123);
		assertEquals(group2.getNthGroup(3), 0);

		NumberBuilder group4 = new NumberBuilder(89076102000L);
		assertEquals(group4.getNthGroup(1), 0);
		assertEquals(group4.getNthGroup(2), 102);
		assertEquals(group4.getNthGroup(3), 76);
		assertEquals(group4.getNthGroup(4), 89);

	}

	@Test
	public void testAddAllGroupsToArrayList() {
		NumberBuilder test = new NumberBuilder(38014001871000L);
		NumberConverter g1 = new NumberConverter(000);
		NumberConverter g2 = new NumberConverter(871);
		NumberConverter g3 = new NumberConverter(1);
		NumberConverter g4 = new NumberConverter(14);
		NumberConverter g5 = new NumberConverter(38);
		assertEquals(test.getGroupArray().get(0).toString(), g1.toString());
		assertEquals(test.getGroupArray().get(1).toString(), g2.toString());
		assertEquals(test.getGroupArray().get(2).toString(), g3.toString());
		assertEquals(test.getGroupArray().get(3).toString(), g4.toString());
		assertEquals(test.getGroupArray().get(4).toString(), g5.toString());

	}

	@Test
	public void testToString() {

		NumberBuilder test1 = new NumberBuilder(19);
		NumberBuilder test2 = new NumberBuilder(123456);
		NumberBuilder test3 = new NumberBuilder(7623919111L);
		assertEquals(test1.toString(), "nineteen");
		assertEquals(test2.toString(),
				"one hundred and twenty three thousand four hundred and fifty six");
		assertEquals(
				test3.toString(),
				"seven billion six hundred and twenty three million nine hundred and nineteen thousand one hundred and eleven");

	}
	
	@Test
	public void testToStringWithZeroes(){
		NumberBuilder test1 = new NumberBuilder(1000);
		NumberBuilder test2 = new NumberBuilder(2000300000);
		NumberBuilder test3 = new NumberBuilder(50000000);
		
		assertEquals(test1.toString(), "one thousand");
		assertEquals(test2.toString(), "two billion three hundred thousand");
		assertEquals(test3.toString(), "fifty million");
	}
}
