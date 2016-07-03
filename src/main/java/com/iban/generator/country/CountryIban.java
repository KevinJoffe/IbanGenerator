package com.iban.generator.country;

import com.iban.CheckDigitGenerator;
import com.iban.IIban;

public class CountryIban implements IIban {

	private final String sCountryCode;
	private final CountryBbanFormat bbanFormat;
	private final int iLength;

	public CountryIban(String sCountryCode, CountryBbanFormat bbanFormat,
			int iLength) {
		this.sCountryCode = sCountryCode;
		this.bbanFormat = bbanFormat;
		this.iLength = iLength;
	}

	@Override
	public String getCountryCode() {
		return sCountryCode;
	}

	@Override
	public String getCheckDigits(String sIban) {
		return CheckDigitGenerator.getCheckDigits(sIban, iLength);
	}

	@Override
	public CountryBbanFormat getBbanFormat() {
		return bbanFormat;
	}

	@Override
	public int getLength() {
		return iLength;
	}

}
