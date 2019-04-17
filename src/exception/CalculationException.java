package exception;

public class CalculationException extends RuntimeException {

    public CalculationException(){

    }

    public CalculationException(String message) {
        super(message);
    }
}
