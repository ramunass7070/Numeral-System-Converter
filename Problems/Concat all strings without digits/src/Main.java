import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }


        for (int i = 0; i < stringBuilder.length(); i++) {
            if (Character.isDigit(stringBuilder.charAt(i))) {
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }
        return stringBuilder.toString();
        // write your code with StringBuilder here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}