package com.iban.generator;

import java.util.Scanner;

import com.iban.SupportedCountryIbanList;
import com.iban.validation.IbanValidator;

public class IbanGeneratorMain {

	private static final String HELP_TEXT = "Welcome to the IBAN generator. Type in a valid country code to generate an IBAN for.\n"
			+ "Currently supported: Germany - 'DE', Austria - 'AT', Netherlands - 'NL'";

	public static void main(String[] args) {
		System.out.println(HELP_TEXT);
		final IbanGenerator ibanGenerator = new IbanGenerator(
				SupportedCountryIbanList.getSupportedCountryIbanList());
		IbanValidator ibanValidator = new IbanValidator(
				SupportedCountryIbanList.getSupportedCountryIbanList());
		Scanner reader = new Scanner(System.in);
		String input = "";
		while (reader.hasNext()) {
			input = reader.next();
			final String iban = ibanGenerator
					.generateRandomIbanForCountry(input.toUpperCase());
			final boolean isValid = ibanValidator.isIbanValid(iban);
			if (isValid) {
				System.out.println(iban);
			}
			else {
				System.out
						.println("Critical error occured - invalid IBAN generated.");
			}
		}

		reader.close();
	}

}
