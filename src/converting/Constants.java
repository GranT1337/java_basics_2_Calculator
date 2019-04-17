package converting;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Constants {
    static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");
    static final List<String> BRACKETS = Arrays.asList("(", ")");
    static final List<String> OPERATORS_AND_BRACKETS = Stream.concat(OPERATORS.stream(), BRACKETS.stream())
                                                                    .collect(Collectors.toList());
}
