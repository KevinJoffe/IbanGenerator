package com.iban;

import com.iban.generator.country.CountryBbanFormat;

public interface IIban {

	public String getCountryCode();

	public String getCheckDigits(String sIban);

	public CountryBbanFormat getBbanFormat();

	public int getLength();

}
