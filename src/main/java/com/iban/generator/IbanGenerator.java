package com.iban.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.iban.BbanFormat;
import com.iban.CheckDigitGenerator;
import com.iban.dictionary.CharacterDictionary;
import com.iban.dictionary.CharacterRange;
import com.iban.generator.country.CountryBbanFormat;
import com.iban.generator.country.CountryIban;

/**
 * Class for generating country-specific or a list of random IBANs.
 * 
 * @author Kevin
 *
 */
public class IbanGenerator {

	private final Map<String, CountryIban> supportedCountryIbanMap = new ConcurrentHashMap<String, CountryIban>();
	private final Map<String, String> generatedIbanMap = new ConcurrentHashMap<String, String>();

	private final Object generatedIbanMapLock = new Object();

	public IbanGenerator(List<CountryIban> supportedCountryIbanList) {
		for (CountryIban supportedCountry : supportedCountryIbanList) {
			this.supportedCountryIbanMap.put(supportedCountry.getCountryCode(),
					supportedCountry);
		}
	}

	public List<String> generateRandomIbans(int iNumberOfIbans) {
		final List<String> randomIbanList = new ArrayList<String>();
		for (int i = 0; i < iNumberOfIbans; i++) {
			randomIbanList.add(generateRandomIban());
		}
		return randomIbanList;
	}

	public boolean isCountrySupported(String sCountryCode) {
		return supportedCountryIbanMap.containsKey(sCountryCode);
	}

	public String generateRandomIbanForCountry(String sCountryCode) {
		if (isCountrySupported(sCountryCode)) {
			return generateRandomIbanForCountry(supportedCountryIbanMap
					.get(sCountryCode));
		}
		return "";
	}

	private final String generateRandomIban() {
		final Random random = new Random();
		int iRandomValue = random.nextInt(supportedCountryIbanMap.size());
		final List<CountryIban> countryIbanList = new ArrayList<CountryIban>(
				supportedCountryIbanMap.values());
		final CountryIban countryIban = countryIbanList.get(iRandomValue);
		String iban = generateRandomIbanForCountry(countryIban);
		synchronized (generatedIbanMapLock) {
			while (generatedIbanMap.containsKey(iban)) {
				iban = generateRandomIbanForCountry(countryIban);
			}
		}
		return iban;
	}

	private final String generateRandomIbanForCountry(CountryIban countryIban) {
		String iban = "";
		// Country code
		iban += countryIban.getCountryCode();
		// Check digits
		iban += "00";
		// The rest according to country bban format
		final CountryBbanFormat countryBbanFormat = countryIban.getBbanFormat();
		Random random = new Random();
		for (BbanFormat bbanFormat : countryBbanFormat.getBbanFormatList()) {
			for (int i = 0; i < bbanFormat.getNumberOfCharacters(); i++) {
				final CharacterRange range = CharacterDictionary
						.getRange(bbanFormat.validateCharacterSetting());
				int iRandomCharValue = random
						.nextInt((range.getMaxValue() - range.getMinValue()) + 1)
						+ range.getMinValue();
				final String s = CharacterDictionary
						.getValueAt(iRandomCharValue);
				iban += s;
			}
		}

		iban = CheckDigitGenerator.replaceCheckDigits(iban,
				countryIban.getLength());

		return iban;
	}
}
