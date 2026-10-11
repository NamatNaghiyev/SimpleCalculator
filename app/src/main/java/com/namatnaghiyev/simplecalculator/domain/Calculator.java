package com.namatnaghiyev.simplecalculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Pure Java calculation logic. No Android dependencies. */
public final class Calculator {
    private Calculator() { }

    public static String calculate(String firstInput, String secondInput, Operation operation) {
        BigDecimal first = parse(firstInput);
        BigDecimal second = parse(secondInput);
        if (operation == null) {
            throw new IllegalArgumentException("Əməliyyat seçilməyib");
        }

        BigDecimal result;
        switch (operation) {
            case ADD:
                result = first.add(second);
                break;
            case SUBTRACT:
                result = first.subtract(second);
                break;
            case MULTIPLY:
                result = first.multiply(second);
                break;
            case DIVIDE:
                if (second.compareTo(BigDecimal.ZERO) == 0) {
                    throw new IllegalArgumentException("Sıfıra bölmək olmaz");
                }
                result = first.divide(second, 10, RoundingMode.HALF_UP);
                break;
            default:
                throw new IllegalArgumentException("Naməlum əməliyyat");
        }
        return result.stripTrailingZeros().toPlainString();
    }

    private static BigDecimal parse(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Hər iki ədədi daxil edin");
        }
        try {
            return new BigDecimal(text.trim().replace(',', '.'));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Düzgün ədəd daxil edin", exception);
        }
    }
}
