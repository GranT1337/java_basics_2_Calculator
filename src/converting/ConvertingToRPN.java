package converting;

import exception.BracketException;

import java.util.*;

public class ConvertingToRPN {

    public List<String> parse(String calculated) throws BracketException {
        MethodsToCheck methods = new MethodsToCheck();

        Stack<String> operators = new Stack<>();
        Stack<String> polishRecord = new Stack<>();
        List<String> list;


        String regex = createRegex();

        List<String> tokenList = Arrays.asList(calculated.split("(?<=[" + regex + "])|(?=[" + regex + "])"));

        for (String token : tokenList) {
            if (methods.isNumber(token)) {
                polishRecord.push(token);
            } else if (methods.isOpenBracket(token)) {
                operators.push(token);
            } else if (methods.isCloseBracket(token)) {

                while (!operators.empty() && !methods.isOpenBracket(operators.lastElement())) {
                    polishRecord.push(operators.pop());
                }

                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                } else {
                    throw new BracketException();
                }

            } else if (methods.isOperator(token)) {

                while (!operators.empty() && methods.isOperator(operators.lastElement()) &&
                        methods.priorityOperator(token) <= methods.priorityOperator(operators.lastElement())) {
                    polishRecord.push(operators.pop());
                }

                operators.push(token);
            }
        }

        while (!operators.empty()) {
            if (operators.peek().equals("(")) {
                throw new BracketException();
            }
            polishRecord.push(operators.pop());
        }

        list = new ArrayList<>(polishRecord);

        return list;
    }


    private String createRegex() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String a: Constants.OPERATORS_AND_BRACKETS) {
            if (a.equals("-")) {
                stringBuilder.append("\\");
            }
            stringBuilder.append(a);
        }

        return stringBuilder.toString();
    }
}
