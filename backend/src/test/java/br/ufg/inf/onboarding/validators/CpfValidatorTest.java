package br.ufg.inf.onboarding.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CpfValidatorTest {
    @Test
    void testCpfValido() {
        assertTrue(CpfValidator.isValid("529.982.247-25"));
        assertTrue(CpfValidator.isValid("52998224725"));
    }

    @Test
    void testCpfInvalido() {
        assertFalse(CpfValidator.isValid("123.456.789-00"));
        assertFalse(CpfValidator.isValid("11111111111"));
        assertFalse(CpfValidator.isValid("00000000000"));
        assertFalse(CpfValidator.isValid(""));
        assertFalse(CpfValidator.isValid(null));
        assertFalse(CpfValidator.isValid("529.982.247-2")); // Menos dígitos
    }
}
