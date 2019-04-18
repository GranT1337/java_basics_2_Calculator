package parsingandvalidate;

import exception.InvalidStringException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validate(String string) {
        String regexForNotNumbers = "[^(.)/*\\-+0-9]";
        String regexForRepeatOps = "[./*\\-+]{2,}";
        String regexForBracketsOperations = "[(][/*][(]|[)][/*][)]";
        String regexForNumNearBrackets = "[\\d?.]+[(]|[)][\\d?.]+";

        Matcher matcherForNotNumbers = Pattern.compile(regexForNotNumbers).matcher(string);
        Matcher matcherForRepeatOps = Pattern.compile(regexForRepeatOps).matcher(string);
        Matcher matcherForBrackets = Pattern.compile(regexForBracketsOperations).matcher(string);
        Matcher matcherForNumNearBrackets = Pattern.compile(regexForNumNearBrackets).matcher(string);

        boolean findBadSymbols1 = matcherForNotNumbers.find();
        boolean findBadSymbols2 = matcherForRepeatOps.find();
        boolean findBadSymbols3 = matcherForBrackets.find();
        boolean findBadSymbols4 = matcherForNumNearBrackets.find();

        if (findBadSymbols1 | findBadSymbols2 | findBadSymbols3 | findBadSymbols4) {
            throw new InvalidStringException("Недопустимая строка");
        }

        return true;
    }
}
