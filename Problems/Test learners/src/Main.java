import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        if (input == 1) {
            System.out.println("Yes!");
        } else if (input > 1 && input < 5) {
            System.out.println("No!");
        } else {
            System.out.println("Unknown number");
        }
    }
}