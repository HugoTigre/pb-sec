package com.pakybytes.sec.services.encryption;

import common.UnitTests;
import org.abstractj.kalium.crypto.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@UnitTests
@DisplayName("Nonce unit tests")
class NonceTest {

    @Test
    @DisplayName("Instance builder should return a Nonce instance")
    void testBuilder() {
        Nonce nonce = new Nonce.Builder().build();
        assertNotNull(nonce);
    }


    @Test
    @DisplayName("The builder should allow for a manual feed of the bytes")
    void testBuilderFromBytes() {

        Nonce nonce = new Nonce.Builder()
                .fromBytes(new Random().randomBytes(24))
                .build();

        assertNotNull(nonce.getRaw());
    }


    @Test
    @DisplayName("Raw bytes of the Nonce should be accessible and not null")
    void getRaw() {
        Nonce nonce = new Nonce.Builder().build();
        assertNotNull(nonce.getRaw());
    }

}