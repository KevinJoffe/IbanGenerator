package com.iban;

import java.util.ArrayList;
import java.util.List;

import com.iban.generator.country.CountryBbanFormat;
import com.iban.generator.country.CountryIban;
import com.iban.generator.country.ECharacterSet;

public class SupportedCountryIbanList {

	public static List<CountryIban> getSupportedCountryIbanList() {
		final List<CountryIban> countryIbanList = new ArrayList<CountryIban>();
		countryIbanList.add(getGermanyIban());
		countryIbanList.add(getAustriaIban());
		countryIbanList.add(getNetherlandsIban());
		return countryIbanList;
	}

	private static final CountryIban getGermanyIban() {
		final CountryBbanFormat bban = new CountryBbanFormat();
		bban.addFormat(18, ECharacterSet.NUMERIC);
		final CountryIban germanyIban = new CountryIban("DE", bban, 22);
		return germanyIban;
	}

	private static final CountryIban getAustriaIban() {
		final CountryBbanFormat bban = new CountryBbanFormat();
		bban.addFormat(16, ECharacterSet.NUMERIC);
		final CountryIban austriaIban = new CountryIban("AT", bban, 20);
		return austriaIban;
	}

	private static final CountryIban getNetherlandsIban() {
		final CountryBbanFormat bban = new CountryBbanFormat();
		bban.addFormat(4, ECharacterSet.UPPER_CASE_ALPHANUMERIC);
		bban.addFormat(10, ECharacterSet.NUMERIC);
		final CountryIban netherlandsIban = new CountryIban("NL", bban, 18);
		return netherlandsIban;
	}
}
