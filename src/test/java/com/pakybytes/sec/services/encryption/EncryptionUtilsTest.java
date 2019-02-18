package com.pakybytes.sec.services.encryption;

import common.UnitTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@UnitTests
@DisplayName("EncryptionUtils unit tests")
class EncryptionUtilsTest {

    private static EncryptionUtils encryptionUtils;
    private static String unencryptedString;
    private static byte[] secret;


    @BeforeAll
    static void setUp() {
        encryptionUtils = new EncryptionUtils();
        unencryptedString = "data";
        secret = "12345678912345678912345678912345".getBytes(); // key must be 32 for secretbox
    }


    @Test
    @DisplayName("Should generate a new secret key")
    void newSecretKey() {
        assertNotNull(encryptionUtils.newSecretKey());
    }


    @Test
    @DisplayName("Should return a map with the nonce and encrypted string")
    void encryptWithNonce() {

        Map<String, String> map = encryptionUtils.encryptWithNonce(secret, unencryptedString);

        assertNotNull(map);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();

        assertNotNull(entry.getValue());
        assertNotNull(entry.getKey());
        assertNotEquals(entry.getValue(), unencryptedString);
    }


    @Test
    @DisplayName("Should encrypt a string")
    void encrypt() {
        String encryptedString = encryptionUtils.encrypt(secret, unencryptedString);
        assertNotNull(encryptedString);
        assertNotEquals(encryptedString, unencryptedString);
    }


    @Test
    @DisplayName("Encrypted string with nonce should be decryptable")
    void decryptWithNonce() {
        Map<String, String> map = encryptionUtils.encryptWithNonce(secret, unencryptedString);
        String decryptedString = encryptionUtils.decryptWithNonce(secret, map);
        assertEquals(unencryptedString, decryptedString);
    }


    @Test
    @DisplayName("Encrypted string should be decryptable")
    void decrypt() {
        String encryptedString = encryptionUtils.encrypt(secret, unencryptedString);
        String decryptedString = encryptionUtils.decrypt(secret, encryptedString);
        assertEquals(unencryptedString, decryptedString);
    }
}