package com.iban.validation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.iban.SupportedCountryIbanList;

public class IbanValidatorTest extends TestCase {

	public IbanValidatorTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(IbanValidatorTest.class);
	}

	/**
	 * Test the expected list of supported countries
	 */
	public void testSupportedCountries() {
		IbanValidator ibanValidator = new IbanValidator(
				SupportedCountryIbanList.getSupportedCountryIbanList());
		assertTrue(ibanValidator.isIbanValid("NL91ABNA0417164300"));
		assertTrue(ibanValidator.isIbanValid("DE44500105175407324931"));
		assertTrue(ibanValidator.isIbanValid("AT611904300234573201"));
	}

	/**
	 * Test invalid Iban values
	 */
	public void testInvalidIbans() {
		IbanValidator ibanValidator = new IbanValidator(
				SupportedCountryIbanList.getSupportedCountryIbanList());
		// incorrect format for Netherlands
		assertFalse(ibanValidator.isIbanValid("NL91ABN10417164300"));
		// incorrect IBAN value Austria
		assertFalse(ibanValidator.isIbanValid("AT611904300234573333"));
		// incorrect IBAN length for Germany
		assertFalse(ibanValidator.isIbanValid("DE445001051754073249312"));
		// dodgy input
		assertFalse(ibanValidator.isIbanValid("000000000000000000"));
		assertFalse(ibanValidator.isIbanValid("AAAAAAAAAAAAAAAAAA"));
		assertFalse(ibanValidator.isIbanValid("?"));
	}
}
