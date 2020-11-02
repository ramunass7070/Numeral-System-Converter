package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder errorMessage = new StringBuilder();

        int sRadix = 0;
        String sourceNumber = null;
        int tRadix = 0;
        Double decimal = -1d;

        System.out.println("source radix:");
        try {
            String sourceRadix = scanner.next();
            sRadix = Integer.parseInt(sourceRadix);
        } catch (Exception e) {
            errorMessage.append("\nwrong input for source radix!");
        }

        System.out.println("source number:");

        try {
            sourceNumber = scanner.next();
            decimal = convertToDecimalBase(sRadix, sourceNumber);
        } catch (Exception e) {
            errorMessage.append("\nConversion to decimal failed!");
        }

        System.out.println("target radix:");

        try {
            String targetRadix = scanner.next();
            tRadix = Integer.parseInt(targetRadix);
            convertToNewBase(decimal, tRadix);
        } catch (Exception e) {
            errorMessage.append("\nconversion failed!");
        }

        if (errorMessage.length() > 0) {
            errorMessage.append("\nerror");
            System.out.println(errorMessage);
        }

    }

    private static Double convertToDecimalBase(int sRadix, String sourceNumber) {
        double decimal;
        boolean isFractional = sourceNumber.contains(".");
        String[] inputArr = new String[2];
        if (isFractional) {
            inputArr = sourceNumber.split("\\.");
        }

        if (sRadix == 1) {
            decimal = sourceNumber.length();
        } else if (sRadix > 1) {
            if (isFractional) {
                decimal = Integer.parseInt(inputArr[0], sRadix) + fractionToDecBase(inputArr[1], sRadix);
            } else {
                decimal = Integer.parseInt(sourceNumber, sRadix);
            }
        } else {
            decimal = -1;
            System.out.println("source radix has not been recognised");
        }
        return decimal;
    }

    private static double fractionToDecBase(String fractionString, int sourceRadix) {
        double fractionDecimal = 0;
        char[] input = fractionString.toCharArray();
        for (int i = 0; i < input.length; i++) {
            fractionDecimal += Character.digit(input[i], sourceRadix) / (Math.pow(sourceRadix, i + 1));
        }
        return fractionDecimal;
    }

    private static void convertToNewBase(Number decimal, int tRadix) {
        //      based on targetRadix value, should the correct converter be called
        StringBuilder output = new StringBuilder();

        if (tRadix == 1) {
            output.append("1".repeat(Math.max(0, decimal.intValue())));
        } else if (tRadix > 1 && tRadix <= Character.MAX_RADIX) {
            double fraction = decimal.doubleValue() - decimal.intValue();
            output.append(Integer.toString(decimal.intValue(), tRadix));
            output.append('.');
            output.append(fractionToNewBase(fraction, tRadix));
        } else {
            System.out.println("target radix is not recognised: valid values are int 1-36");
            System.out.println("error");
        }

        System.out.println(output);

    }

    private static String fractionToNewBase(Double fraction, int newBase) {
        StringBuilder stringBuilder = new StringBuilder();
        double temp;
        for (int i = 0; i < 5; i++) {
            temp = fraction * newBase;
            stringBuilder.append(Character.forDigit(((int) temp), 36));
            fraction = temp % 1;
        }

        System.out.println("fractional part in Base '" + newBase + "': " + stringBuilder.toString());
        return stringBuilder.toString();
    }

}

