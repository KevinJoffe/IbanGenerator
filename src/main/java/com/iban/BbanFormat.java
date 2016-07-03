package com.iban;

import com.iban.generator.country.ECharacterSet;

public class BbanFormat {
	final int iNumChars;
	final ECharacterSet eValidCharacterSetting;

	public BbanFormat(int iNumChars,
			ECharacterSet eValidCharacterSetting) {
		this.iNumChars = iNumChars;
		this.eValidCharacterSetting = eValidCharacterSetting;
	}

	public int getNumberOfCharacters() {
		return iNumChars;
	}

	public ECharacterSet validateCharacterSetting() {
		return eValidCharacterSetting;
	}
}