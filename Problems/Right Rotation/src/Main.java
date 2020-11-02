import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String[] firstInputLine = scanner.nextLine().split(" ");
        int numOfRotation = scanner.nextInt();


        int[] arrOfNum = new int[firstInputLine.length];
        for (int i = 0; i < firstInputLine.length; i++) {
            arrOfNum[i] = Integer.parseInt(firstInputLine[i]);
        }


        for (int i = 0; i < numOfRotation % arrOfNum.length; i++) {
            arrOfNum = rightRotation(arrOfNum);
        }

        for (int a : arrOfNum) {
            System.out.print(a + " ");
        }
    }

    static int[] rightRotation(int[] inputArray) {
        int[] rotated = new int[inputArray.length];
        for (int i = 1; i < inputArray.length; i++) {
            rotated[i] = inputArray[i - 1];
        }
        rotated[0] = inputArray[inputArray.length - 1];
        return rotated;
    }


}