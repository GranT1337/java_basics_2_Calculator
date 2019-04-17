package calculation;

import exception.DivisionByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Operators {
    PLUS("+") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },
    MULTIPLY("-") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    },
    TIMES("*") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE("/") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            if (y.equals(new BigDecimal(0))) {
                throw new DivisionByZeroException("Деление на ноль запрещено");
            }
            return x.divide(y, 20, RoundingMode.HALF_UP);
        }
    };


    String value;

    Operators(String value) {
        this.value = value;
    }

    public static Operators getEnum(String value) {
        for (Operators operator : values())
            if (operator.getValue().equals(value)) return operator;
        throw new IllegalArgumentException();
    }

    abstract BigDecimal apply(BigDecimal x, BigDecimal y);

    public String getValue() {
        return value;
    }
}
