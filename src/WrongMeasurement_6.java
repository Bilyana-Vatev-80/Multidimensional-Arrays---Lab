import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurement_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArr(scanner, "\\s+");
        }
        int[] valueIndexes = readArr(scanner, "\\s+");
        int wrongValues = matrix[valueIndexes[0]][valueIndexes[1]];

        List<int[]> indexes = new ArrayList<>(); // лист за грешните числа
        List<Integer> correctValues = new ArrayList<>(); // лист за вярните числа

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValues) { //ако текущия елемент е = грешния елемент
                    indexes.add(new int[]{row, col}); // добавяма в листа
                    correctValues.add(getCorrectValues(matrix, row, col)); //добавяме в листа
                }
            }
        }
        // обикаляме някой от листите и презаписваме данните в матрицата
        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndCol = indexes.get(i);
            matrix[rowAndCol[0]][rowAndCol[1]] = correctValues.get(i);
        }
        // печатаме на конзолата
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValues(int[][] matrix, int row, int col) {
        int sum = 0;
        int wrongValue = matrix[row][col]; // смятаме сумата около грешното число

        if (isInBounds(matrix, row - 1, col) && wrongValue != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];// започваме от смаятане на долния ред
        }
        if (isInBounds(matrix, row + 1, col) && wrongValue != matrix[row + 1][col]) {
            sum += matrix[row + 1][col]; //смятаме на долния ред
        }
        if (isInBounds(matrix, row, col - 1) && wrongValue != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];// смятаме на ляво
        }
        if (isInBounds(matrix, row, col + 1) && wrongValue != matrix[row][col + 1]) {
            sum += matrix[row][col + 1];// смяраме на дясно
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
        // метод за валидност на индексите
    }

    private static boolean isOutOfBounds(int[][] matrix, int row, int col) {
        return !isInBounds(matrix, row, col); // метод за извън матрицата на индексите
    }

    public static int[] readArr(Scanner scanner, String separator) {
        return Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray(); // добавяне на данните от конзолата в матрицата
    }
}
