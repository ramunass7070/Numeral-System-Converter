import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] inputArray = new int[size];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = scanner.nextInt();
        }

        int min = inputArray[0];
        for (int a : inputArray) {
            if (a < min) {
                min = a;
            }
        }
        System.out.println(min);
    }
}