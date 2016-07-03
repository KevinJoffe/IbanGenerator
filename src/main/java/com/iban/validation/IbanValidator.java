package com.iban.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iban.generator.country.CountryIban;
import com.iban.utility.PieceWiseModuloOperation;

public class IbanValidator {

	private final Map<String, CountryIban> supportedCountryIbanMap = new HashMap<String, CountryIban>();

	public IbanValidator(List<CountryIban> supportedCountryIbanList) {
		for (CountryIban supportedCountry : supportedCountryIbanList) {
			this.supportedCountryIbanMap.put(supportedCountry.getCountryCode(),
					supportedCountry);
		}
	}

	public boolean isIbanValid(String sIban) {
		String sCountryCode = "";
		for (String countryCode : supportedCountryIbanMap.keySet()) {
			if (sIban.startsWith(countryCode)) {
				sCountryCode = countryCode;
				break;
			}
		}

		if (sCountryCode.equals("")) {
			return false;
		}

		final CountryIban countryIban = supportedCountryIbanMap
				.get(sCountryCode);
		if (sIban.length() != countryIban.getLength()) {
			return false;
		}

		sIban = sIban.substring(4) + sIban.substring(0, 4);

		String sDigitFormatIban = "";
		for (int i = 0; i < sIban.length(); i++) {
			sDigitFormatIban += getValue(sIban.substring(i, i + 1));
		}

		while (sDigitFormatIban.startsWith("0")) {
			sDigitFormatIban = sDigitFormatIban.substring(1);
		}

		try {
			int rem = PieceWiseModuloOperation.moduloOperation(sDigitFormatIban, 97);
			if (rem == 1) {
				return true;
			}
		}
		catch (NumberFormatException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	private static int getValue(String s) {
		if (s.length() != 1) {
			throw new IllegalArgumentException(
					"expected to converted one character");
		}

		char[] c = s.toCharArray();

		if (Character.isDigit(c[0])) {
			return Integer.parseInt(s);
		}
		else if (s.equalsIgnoreCase("a")) {
			return 10;
		}
		else if (s.equalsIgnoreCase("b")) {
			return 11;
		}
		else if (s.equalsIgnoreCase("c")) {
			return 12;
		}
		else if (s.equalsIgnoreCase("d")) {
			return 13;
		}
		else if (s.equalsIgnoreCase("e")) {
			return 14;
		}
		else if (s.equalsIgnoreCase("f")) {
			return 15;
		}
		else if (s.equalsIgnoreCase("g")) {
			return 16;
		}
		else if (s.equalsIgnoreCase("h")) {
			return 17;
		}
		else if (s.equalsIgnoreCase("i")) {
			return 18;
		}
		else if (s.equalsIgnoreCase("j")) {
			return 19;
		}
		else if (s.equalsIgnoreCase("k")) {
			return 20;
		}
		else if (s.equalsIgnoreCase("l")) {
			return 21;
		}
		else if (s.equalsIgnoreCase("m")) {
			return 22;
		}
		else if (s.equalsIgnoreCase("n")) {
			return 23;
		}
		else if (s.equalsIgnoreCase("o")) {
			return 24;
		}
		else if (s.equalsIgnoreCase("p")) {
			return 25;
		}
		else if (s.equalsIgnoreCase("q")) {
			return 26;
		}
		else if (s.equalsIgnoreCase("r")) {
			return 27;
		}
		else if (s.equalsIgnoreCase("s")) {
			return 28;
		}
		else if (s.equalsIgnoreCase("t")) {
			return 29;
		}
		else if (s.equalsIgnoreCase("u")) {
			return 30;
		}
		else if (s.equalsIgnoreCase("v")) {
			return 31;
		}
		else if (s.equalsIgnoreCase("w")) {
			return 32;
		}
		else if (s.equalsIgnoreCase("x")) {
			return 33;
		}
		else if (s.equalsIgnoreCase("y")) {
			return 34;
		}
		else if (s.equalsIgnoreCase("z")) {
			return 35;
		}
		else {
			throw new IllegalArgumentException("Iban has invalid characters");
		}
	}
	
}
