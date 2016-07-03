package com.iban.generator.country;

import java.util.ArrayList;
import java.util.List;

import com.iban.BbanFormat;

public class CountryBbanFormat {
	/** In-order list of Bban formats to use for this country */
	private List<BbanFormat> formatList;

	public CountryBbanFormat() {
		formatList = new ArrayList<BbanFormat>();
	}

	public CountryBbanFormat(final List<BbanFormat> orderedBbanFormatList) {
		this.formatList = orderedBbanFormatList;
	}

	public void addFormat(int iNumChars,
			ECharacterSet eValidCharacterSetting) {
		formatList.add(new BbanFormat(iNumChars, eValidCharacterSetting));
	}

	public List<BbanFormat> getBbanFormatList() {
		return formatList;
	}

}
