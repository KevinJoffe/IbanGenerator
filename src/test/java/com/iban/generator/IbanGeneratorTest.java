package com.iban.generator;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.iban.SupportedCountryIbanList;
import com.iban.validation.IbanValidator;

public class IbanGeneratorTest extends TestCase {

	public IbanGeneratorTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(IbanGeneratorTest.class);
	}

	/**
	 * Test IBAN generator output with the IBAN validator
	 */
	public void testIbanGenerator() {
		IbanGenerator ibanGenerator = new IbanGenerator(
				SupportedCountryIbanList.getSupportedCountryIbanList());
		IbanValidator ibanValidator = new IbanValidator(
				SupportedCountryIbanList.getSupportedCountryIbanList());

		List<String> ibanList = ibanGenerator.generateRandomIbans(10);
		for (String iban : ibanList) {
			assertTrue(ibanValidator.isIbanValid(iban));
		}

		String germanIban = ibanGenerator.generateRandomIbanForCountry("DE");
		assertTrue(ibanValidator.isIbanValid(germanIban));
	}

}
