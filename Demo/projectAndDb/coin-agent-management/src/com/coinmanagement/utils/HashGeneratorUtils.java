package com.coinmanagement.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HashGenerationException extends Exception {

	public HashGenerationException() {
		super();
	}
	
	public HashGenerationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public HashGenerationException(String message) {
		super(message);
	}

	public HashGenerationException(Throwable throwable) {
		super(throwable);
	}
}

public class HashGeneratorUtils {
    private HashGeneratorUtils() {}

    public static String generateSHA256(String message) throws HashGenerationException {
        return hashString(message, "SHA-256");
    }
 
    private static String hashString(String message, String algorithm)
            throws HashGenerationException {
 
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
 
            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new HashGenerationException(
                    "Could not generate hash from String", ex);
        }
    }
 
    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}
