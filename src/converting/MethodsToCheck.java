package converting;

import converting.Constants;

public class MethodsToCheck {


    public boolean isNumber(String symbol) {
        try {
            Double.parseDouble(symbol);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isOperator(String symbol) {
        return Constants.OPERATORS.contains(symbol);
    }

    public boolean isOpenBracket(String symbol) {
        return symbol.equals("(");
    }

    public boolean isCloseBracket(String symbol) {
        return symbol.equals((")"));
    }

    public int priorityOperator(String symbol) {
        if (symbol.equals("+") || symbol.equals("-")) {
            return 1;
        }

        return 2;
    }


}
