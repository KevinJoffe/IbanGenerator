package com.iban.utility;

public class PieceWiseModuloOperation {
	public static int moduloOperation(String value, int mod) {
		int iPos = 0;
		if (value.length() < 9) {
			try {
				final int out = Integer.parseInt(value) % mod;
				return out;
			}
			catch(NumberFormatException ex) {
				
			}
		}
		String sCurrentPiece = value.substring(0, 9);
		iPos = 9;
		int iPieceRemainder = 0;
		try {
			iPieceRemainder = Integer.parseInt(sCurrentPiece);
			iPieceRemainder = iPieceRemainder % 97;
		}
		catch (NumberFormatException ex) {

		}

		int iRemainingCharCount = value.length() - iPos;
		while (iRemainingCharCount > 0) {
			if (iRemainingCharCount < 7) {
				if(iPieceRemainder < 10) {
					sCurrentPiece = "0" + iPieceRemainder
							+ value.substring(iPos, iPos + iRemainingCharCount);
				}
				else {
					sCurrentPiece = iPieceRemainder
							+ value.substring(iPos, iPos + iRemainingCharCount);	
				}
				
				try {
					iPieceRemainder = Integer.parseInt(sCurrentPiece);
					iPieceRemainder = iPieceRemainder % 97;
				}
				catch (NumberFormatException ex) {

				}
				iPos += iRemainingCharCount;
			}
			else {
				if(iPieceRemainder < 10) {
					sCurrentPiece = "0" + iPieceRemainder
							+ value.substring(iPos, iPos + 7);
				}
				else {
					sCurrentPiece = iPieceRemainder
							+ value.substring(iPos, iPos + 7);	
				}
				
				try {
					iPieceRemainder = Integer.parseInt(sCurrentPiece);
					iPieceRemainder = iPieceRemainder % 97;
				}
				catch (NumberFormatException ex) {

				}
				iPos += 7;
			}
			iRemainingCharCount = value.length() - iPos;
		}
		return iPieceRemainder;
	}
}
