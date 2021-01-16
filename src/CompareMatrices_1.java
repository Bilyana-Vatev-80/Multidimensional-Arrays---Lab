import java.util.Scanner;

public class CompareMatrices_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");

    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) { // дава ни редовете в мартрицата
            return false;
        }
        for (int rows = 0; rows < firstMatrix.length; rows++) { // обхождаме елементите на редовете дали са ни еднакви
            int[] firstArr = firstMatrix[rows];
            int[] secondArr = secondMatrix[rows];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int cols = 0; cols < firstArr.length; cols++) { // обхождаме елементите в колоните дали са еднакви
                if (firstArr[cols] != secondArr[cols]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readMatrix(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cows = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cows];

        for (int r = 0; r < rows; r++) {
            String[] lines = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cows; c++) {
                matrix[r][c] = Integer.parseInt(lines[c]);
            }
        }
        return matrix;
    }
}
