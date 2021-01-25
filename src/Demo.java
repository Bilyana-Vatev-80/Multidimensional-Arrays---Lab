import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 4;

        int[][] m = new int[n][n];

        for (int row = 0; row < n; row++) {
            m[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int row = 0;
        int col = 0;
        while (row < n) {
            int innerRow = row;
            int innerCol = col;
            while (innerRow < n && innerCol < n) {
                System.out.print(m[innerRow][innerCol] + " ");
                innerRow--;
                innerCol++;
            }
            System.out.println();
            row++;
            if (col < n - 1) {
                row--;
                col++;
            }
        }
    }
}
