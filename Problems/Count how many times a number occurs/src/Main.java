import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }

        int num = scanner.nextInt();

        int counter = 0;
        for (int a : input) {
            if (a == num) {
                counter++;
            }
        }

        System.out.println(counter);

    }
}