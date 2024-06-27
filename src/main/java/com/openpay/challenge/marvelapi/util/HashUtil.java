package com.openpay.challenge.marvelapi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

 public static String generateHash(String timestamp, String privateKey, String publicKey) {
    try {
        String input = timestamp + privateKey + publicKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] byteData = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte byteDatum : byteData) {
            String hex = Integer.toHexString(0xff & byteDatum);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}

}
