package calculation;

import converting.MethodsToCheck;
import exception.DivisionByZeroException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class CalculationRPN {

    public BigDecimal calculations(List<String> polishRecord) throws DivisionByZeroException {
        MethodsToCheck methods = new MethodsToCheck();
        Stack<BigDecimal> output = new Stack<>();

        BigDecimal temporaryValue;

        for (String element : polishRecord) {
            if (methods.isNumber(element)) {
                output.push(new BigDecimal(element));
            } else {
                temporaryValue = Operators.getEnum(element).apply(output.get((output.size()-1)-1), output.pop());
                output.pop();
                output.push(temporaryValue);
            }
        }

        return output.pop();
    }
}
