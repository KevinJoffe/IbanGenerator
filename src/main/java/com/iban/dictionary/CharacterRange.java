package com.iban.dictionary;

public class CharacterRange {
	private final int iMinValue;
	private final int iMaxValue;

	public CharacterRange(final int iMinValue, final int iMaxValue) {
		this.iMinValue = iMinValue;
		this.iMaxValue = iMaxValue;
	}

	public int getMinValue() {
		return iMinValue;
	}

	public int getMaxValue() {
		return iMaxValue;
	}
}
