package com.namatnaghiyev.simplecalculator.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {
    @Test public void addsDecimalsPrecisely() {
        assertEquals("0.3", Calculator.calculate("0.1", "0.2", Operation.ADD));
    }
    @Test public void subtractsNegativeNumbers() {
        assertEquals("-2", Calculator.calculate("-5", "-3", Operation.SUBTRACT));
    }
    @Test public void multipliesNumbers() {
        assertEquals("30", Calculator.calculate("5", "6", Operation.MULTIPLY));
    }
    @Test public void dividesNumbers() {
        assertEquals("2.5", Calculator.calculate("5", "2", Operation.DIVIDE));
    }
    @Test public void acceptsDecimalComma() {
        assertEquals("4", Calculator.calculate("1,5", "2,5", Operation.ADD));
    }
    @Test public void roundsRepeatingDecimal() {
        assertEquals("0.3333333333", Calculator.calculate("1", "3", Operation.DIVIDE));
    }
    @Test public void rejectsDivisionByZero() {
        expectError("Sıfıra bölmək olmaz", "6", "0", Operation.DIVIDE);
    }
    @Test public void rejectsBlankInput() {
        expectError("Hər iki ədədi daxil edin", "", "4", Operation.ADD);
    }
    @Test public void rejectsInvalidInput() {
        expectError("Düzgün ədəd daxil edin", "abc", "4", Operation.ADD);
    }
    @Test public void rejectsMissingOperation() {
        expectError("Əməliyyat seçilməyib", "2", "2", null);
    }
    private static void expectError(String message, String left, String right, Operation operation) {
        try {
            Calculator.calculate(left, right, operation);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals(message, exception.getMessage());
        }
    }
}
