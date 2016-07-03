package com.iban.dictionary;

import com.iban.generator.country.ECharacterSet;

public class CharacterDictionary {

	private static final String[] DICTIONARY = new String[] { "0", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };

	public static CharacterRange getRange(ECharacterSet eValidCharacterSetting) {
		if (eValidCharacterSetting == ECharacterSet.UPPER_CASE_ALPHANUMERIC) {
			return new CharacterRange(10, 35);
		}
		else if (eValidCharacterSetting == ECharacterSet.NUMERIC) {
			return new CharacterRange(0, 9);
		}
		else if (eValidCharacterSetting == ECharacterSet.MIXED_CASE_ALPHANUMERIC) {
			return new CharacterRange(0, 61);
		}
		else {
			throw new IllegalArgumentException(
					"Validating range for unknown character setting "
							+ eValidCharacterSetting);
		}
	}

	public static String getValueAt(int index) {
		return DICTIONARY[index];
	}

	public static String getDictionaryAsString() {
		String sDictionaryString = "";
		for (int i = 0; i < DICTIONARY.length; i++) {
			sDictionaryString += DICTIONARY[i];
		}
		return sDictionaryString;
	}
}
