package shuaicj.hello.enumtest;

import java.util.HashMap;
import java.util.Map;

/**
 * An enum representing four types of math operation.
 *
 * @author shuaicj 2017/02/05
 */
public enum Operation {

    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private static final Map<String, Operation> stringToEnum = new HashMap<>();

    static {
        for (Operation op : Operation.values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

}
