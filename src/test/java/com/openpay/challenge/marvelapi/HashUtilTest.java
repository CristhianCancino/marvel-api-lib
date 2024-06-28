package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.util.HashUtil;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class HashUtilTest {

    @Test
    public void generateHashThrowsExceptionWhenMessageDigestFails() throws NoSuchAlgorithmException {
        try (MockedStatic<MessageDigest> mdMock = Mockito.mockStatic(MessageDigest.class)) {
            mdMock.when(() -> MessageDigest.getInstance("MD5")).thenThrow(NoSuchAlgorithmException.class);
            assertThrows(RuntimeException.class, () -> HashUtil.generateHash("1", "key", "public"));
        }
    }

    @Test
    public void generateHashThrowsExceptionWhenTimestampIsNull() {
        assertThrows(NullPointerException.class, () -> HashUtil.generateHash(null, "key", "public"));
    }

    @Test
    public void generateHashThrowsExceptionWhenPrivateKeyIsNull() {
        assertThrows(NullPointerException.class, () -> HashUtil.generateHash("1", null, "public"));
    }

    @Test
    public void generateHashThrowsExceptionWhenPublicKeyIsNull() {
        assertThrows(NullPointerException.class, () -> HashUtil.generateHash("1", "key", null));
    }
}