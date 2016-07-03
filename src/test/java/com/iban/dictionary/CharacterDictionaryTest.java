package com.iban.dictionary;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CharacterDictionaryTest extends TestCase {

	public CharacterDictionaryTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CharacterDictionaryTest.class);
	}

	/**
	 * Dictionary Test
	 */
	public void testCharacterDictionary() {
		final String sExpectedDictionaryString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		assertEquals("0", CharacterDictionary.getValueAt(0));
		assertEquals("9", CharacterDictionary.getValueAt(9));
		assertEquals("A", CharacterDictionary.getValueAt(10));
		assertEquals("Z", CharacterDictionary.getValueAt(35));
		assertEquals("a", CharacterDictionary.getValueAt(36));
		assertEquals("z", CharacterDictionary.getValueAt(61));

		assertEquals(sExpectedDictionaryString,
				CharacterDictionary.getDictionaryAsString());
	}

}
