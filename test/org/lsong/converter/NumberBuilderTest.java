package org.lsong.converter;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberBuilderTest {

	@Test
	public void testGetLength(){
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
	public void testAddGroupToArrayList(){
		NumberBuilder test = new NumberBuilder(123456);
		assertTrue(test.addGroupToArrayList(456));
		assertTrue(test.addGroupToArrayList(123));
	}
	
	@Test
	public void testGetCountOfGroups(){
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
}
