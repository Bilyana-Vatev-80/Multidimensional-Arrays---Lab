import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int index = 0; index < rows; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();

        for (int index = 0; index < rows; index++) {
            System.out.print(matrix[(rows - 1) - index][index] + " ");
        }
    }
}
