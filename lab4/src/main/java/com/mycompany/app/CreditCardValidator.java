package com.mycompany.app;

public class CreditCardValidator {

    public boolean IsAdult(Integer age) throws NumberLessThanZeroException {
        if (age < 0) {
            throw new NumberLessThanZeroException("Age can't be less than 0");
        }

        return age >= 18;
    }

    public boolean IsNameCorrect(String name) throws StringToShortException, StringNotAsciiException {
        if (name.length() < 3) {
            throw new StringToShortException("Name should have minimum 3 characters");
        }
        if (!name.matches("\\p{Alpha}*")) {
            throw new StringNotAsciiException("Name should only contain ASCII characters");
        }

        return true;
    }

    public boolean IsCvvCorrect(String cvv) throws CvvLengthIncorrectException, CvvNotANumberException {
        if (cvv.length() == 3 && cvv.matches("-?\\d+(\\.\\d+)?")) {
            return true;
        }
        throw new CvvLengthIncorrectException("Cvv length should be 3 characters long and contain only numbers");
    }
}
