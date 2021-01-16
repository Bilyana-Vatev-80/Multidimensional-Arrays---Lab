import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        fillTheMatrix(scanner, matrix, size, size);
        int row = 0;
        int col = 0;

        while (row < matrix.length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
        row = matrix.length - 1;
        col = 0;
        while (col < matrix.length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

    }

    private static void fillTheMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
