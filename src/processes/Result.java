package processes;


import calculation.CalculationRPN;
import converting.ConvertingToRPN;
import exception.BracketException;
import exception.InvalidStringException;
import parsingandvalidate.ParsingToNormalView;
import parsingandvalidate.Validator;

import java.math.BigDecimal;
import java.util.List;

public class Result {
    private CalculationRPN calculationRPN = new CalculationRPN();
    private ConvertingToRPN convertingToRPN = new ConvertingToRPN();
    private ParsingToNormalView parsingToNormalView = new ParsingToNormalView();

    public BigDecimal result(String calculated) {

        try {
            calculated = parsingToNormalView.parsingToNormalView(calculated);
            Validator.validate(calculated);
            List<String> tmpListRPN = convertingToRPN.parse(calculated);
            return calculationRPN.calculations(tmpListRPN);
        } catch (BracketException e) {
            System.err.println("Неправильное положение скобок");
            System.exit(0);
        }
        return null;
    }
}
