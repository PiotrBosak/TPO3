package servlets;


import lombok.AllArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor

public class Input {
    public static final String INT_REGEX = "\\d+";
    private final String firstOperand;
    private final String secondOperand;

    public String calculateSum() {
        if (isInputNull())
            return "";
        else if (isInputCorrect())
            return Integer.parseInt(secondOperand) + Integer.parseInt(firstOperand) + "";
        return "Input values are not correct";
    }

    private boolean isInputCorrect() {
        Pattern pattern = Pattern.compile(INT_REGEX);
        Matcher matcher1 = pattern.matcher(firstOperand);
        Matcher matcher2 = pattern.matcher(secondOperand);
        return matcher1.matches() && matcher2.matches();

    }

    private boolean isInputNull() {
        return !(firstOperand != null && secondOperand != null);
    }
}
