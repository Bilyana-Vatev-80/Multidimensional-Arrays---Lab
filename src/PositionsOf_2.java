import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];
        boolean isEqual = false;
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int number = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == number) {
                    System.out.println(row + " " + col);
                    isEqual = true;
                }
            }
        }
        if (!isEqual) {
            System.out.println("not found");
        }
    }
}
