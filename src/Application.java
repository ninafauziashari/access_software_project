import java.math.BigDecimal;
import java.util.*;

import static java.lang.String.valueOf;

class Application {
    void run() {
        boolean running = true;
        var input = new Scanner(System.in);
        String num;

        try {
            while (running) {
                System.out.print("Insert a number: ");
                num = setDollarAndCent(input.nextDouble());

                System.out.println(num);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid number");
        }
         input.close();
    }

    private static Map<Integer, String> getSingleNumber() {
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(0, "");
        numberMap.put(1, valueOf(NumberString.one));
        numberMap.put(2, valueOf(NumberString.two));
        numberMap.put(3, valueOf(NumberString.three));
        numberMap.put(4, valueOf(NumberString.four));
        numberMap.put(5, valueOf(NumberString.five));
        numberMap.put(6, valueOf(NumberString.six));
        numberMap.put(7, valueOf(NumberString.seven));
        numberMap.put(8, valueOf(NumberString.eight));
        numberMap.put(9, valueOf(NumberString.nine));

        return numberMap;
    }

    private static Map<Integer, String> getTeens() {
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(1, valueOf(Teens.eleven));
        numberMap.put(2, valueOf(Teens.twelve));
        numberMap.put(3, valueOf(Teens.thirteen));
        numberMap.put(4, valueOf(Teens.fourteen));
        numberMap.put(5, valueOf(Teens.fifteen));
        numberMap.put(6, valueOf(Teens.sixteen));
        numberMap.put(7, valueOf(Teens.seventeen));
        numberMap.put(8, valueOf(Teens.eighteen));
        numberMap.put(9, valueOf(Teens.nineteen));;

        return numberMap;
    }

    private static Map<Integer, String> getTens() {
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(1, valueOf(Tens.ten));
        numberMap.put(2, valueOf(Tens.twenty));
        numberMap.put(3, valueOf(Tens.thirty));
        numberMap.put(4, valueOf(Tens.forty));
        numberMap.put(5, valueOf(Tens.fifty));
        numberMap.put(6, valueOf(Tens.sixty));
        numberMap.put(7, valueOf(Tens.seventy));
        numberMap.put(8, valueOf(Tens.eighty));
        numberMap.put(9, valueOf(Tens.ninety));

        return numberMap;
    }

    String setDollarAndCent(Double dollar) {
        BigDecimal amount = BigDecimal.valueOf(dollar);
        int wholeDollar = amount.intValue();
        int cent = amount.remainder(BigDecimal.ONE).multiply(BigDecimal.valueOf(100)).intValue();

        Map<Integer, String> singleDigit = getSingleNumber();
        Map<Integer, String> teens = getTeens();
        Map<Integer, String> tens = getTens();

        String convertDollar = convertToWordHelper(wholeDollar, singleDigit, teens, tens);
        String convertCent = convertToWordHelper(cent, singleDigit, teens, tens);

       Currency dollarCurrency = (Objects.equals(convertDollar, valueOf(NumberString.one)) ? Currency.dollar : Currency.dollars);
       Currency centCurrency = (Objects.equals(convertCent, valueOf(NumberString.one)) ? Currency.cent : Currency.cents);

        if (wholeDollar > 0 && cent > 0) {
            return convertDollar + " " + dollarCurrency + " and " + convertCent + " " + centCurrency;
        }
        else if (wholeDollar == 0 && cent > 0) {
            return convertCent + " " + centCurrency;
        }
        else if (wholeDollar == 0 && cent == 0) {
            return "No value";
        }
        return convertDollar + " " + dollarCurrency;
    }

    private String convertToWordHelper(Integer number,
                                       Map<Integer, String> singleNumber,
                                       Map<Integer,String> teensNumber,
                                       Map<Integer, String> tensNumber) {

        if (number == 10) {
            return valueOf(Tens.ten);
        }
        if (number < 10) {
            return singleNumber.get(number);
        }
        if (number < 20) {
            return teensNumber.get(number - 10);
        }
        else if (number < 100) {
            return convertTwoDigitNumber(number, tensNumber, singleNumber);
        }
        else if (number < 1000) {
            return convertThreeDigitNumber(number, singleNumber, teensNumber, tensNumber);
        }
        else if (number < 10000) {
            return convertFourDigitNumber(number, singleNumber, teensNumber, tensNumber);
        }
        return "Unable to convert to number";
    }

    private String convertTwoDigitNumber(int number, Map<Integer, String> tensNumber, Map<Integer, String> singleNumber) {
        int unitsPlaceValue = number % 10;
        int tensDigit = number / 10;
        int tensPlaceValue = (number / 10) % 10;

        if (unitsPlaceValue == 0) {
            return tensNumber.get(tensDigit);
        }
        return tensNumber.get(tensDigit)
                + " " + singleNumber.get(unitsPlaceValue);
    }

    private String convertThreeDigitNumber(int number, Map<Integer, String> singleNumber,
                                           Map<Integer, String> teensNumber, Map<Integer, String> tensNumber) {
        int unitsPlaceValue = number % 10;
        int tensPlaceValue = (number / 10) % 10;

        int hundredsDigit = number / 100;
        int hundredsRemaining = number % 100;

        if (unitsPlaceValue == 0) {
            return singleNumber.get(hundredsDigit)
                    + " " + MultipleZeroes.hundred
                    + (tensPlaceValue > 0
                            ? " and " + tensNumber.get(tensPlaceValue)
                            : "");
        }
        return singleNumber.get(hundredsDigit)
            + " "
            + MultipleZeroes.hundred
            + (unitsPlaceValue > 0
                    ? " and "
                : "")
            + (tensPlaceValue > 0
                ? (tensPlaceValue == 1)
                    ? (teensNumber.get(hundredsRemaining - 10))
                    : tensNumber.get(tensPlaceValue)
                : "")
            + (tensPlaceValue == 1 ? "" : (" " + singleNumber.get(unitsPlaceValue))) ;
    }

    private String convertFourDigitNumber(int number, Map<Integer, String> singleNumber,
                                          Map<Integer, String> teensNumber, Map<Integer, String> tensNumber) {
        int unitsPlaceValue = number % 10;
        int tensPlaceValue = (number / 10) % 10;

        int hundredsPlaceValue = (number / 100) % 10;
        int hundredsRemaining = number % 100;

        int thousandsDigit = number / 1000;

        if (unitsPlaceValue == 0) {
            return singleNumber.get(thousandsDigit)
                + " " + MultipleZeroes.thousand + " "
                + singleNumber.get(hundredsPlaceValue)
                + (hundredsPlaceValue > 0 ? (" " + MultipleZeroes.hundred) : "")
                + (tensPlaceValue > 0 ? " and " + tensNumber.get(tensPlaceValue) : "");
        }
        return singleNumber.get(thousandsDigit)
            + " "
            + MultipleZeroes.thousand
            + " "
            + singleNumber.get(hundredsPlaceValue)
            + (hundredsPlaceValue > 0 ? (" " + MultipleZeroes.hundred) : "")
            + " and "
            + (tensPlaceValue == 1
                    ? (teensNumber.get(hundredsPlaceValue == 0
                        ? tensPlaceValue
                        : hundredsRemaining - 10))
                    : (tensPlaceValue > 0 ? tensNumber.get(tensPlaceValue) : ""))
            + (tensPlaceValue == 1 ? " " : ("  " + (singleNumber.get(unitsPlaceValue))));
    }
}
