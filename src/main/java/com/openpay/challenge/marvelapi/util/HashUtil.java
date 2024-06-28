package com.openpay.challenge.marvelapi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Utility class to generate hash for Marvel API.
 */
public class HashUtil {

  /**
   * Generates a hash for the Marvel API.
   *
   * @param timestamp  The timestamp.
   * @param privateKey The private key.
   * @param publicKey  The public key.
   * @return The generated hash.
   */
  public static String generateHash(String timestamp, String privateKey, String publicKey) {
    Objects.requireNonNull(timestamp, "Timestamp cannot be null");
    Objects.requireNonNull(privateKey, "Private key cannot be null");
    Objects.requireNonNull(publicKey, "Public key cannot be null");

    try {
      String input = timestamp + privateKey + publicKey;
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(input.getBytes());
      byte[] byteData = md.digest();
      StringBuilder hexString = new StringBuilder();
      for (byte byteDatum : byteData) {
        String hex = Integer.toHexString(0xff & byteDatum);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

}
