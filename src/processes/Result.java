package processes;


import calculation.CalculationRPN;
import converting.ConvertingToRPN;
import exception.BracketException;
import exception.InvalidStringException;
import parsingandvalidate.ParsingToNormalView;
import parsingandvalidate.Validator;

import java.math.BigDecimal;

public class Result {
    private CalculationRPN calculations = new CalculationRPN();
    private ConvertingToRPN converting = new ConvertingToRPN();
    private ParsingToNormalView parsingToNormalView = new ParsingToNormalView();

    public BigDecimal result(String calculated) {

        try {
            calculated = parsingToNormalView.parsingToNormalView(calculated);
            Validator.validate(calculated);
            return calculations.calculations(converting.parse(calculated));
        } catch (InvalidStringException e) {
            System.err.println("Недопустимая строка");
            System.exit(0);
        } catch (BracketException e) {
            System.err.println("Неправильное положение скобок");
            System.exit(0);
        }
        return null;
    }
}
