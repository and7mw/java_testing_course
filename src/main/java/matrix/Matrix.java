package matrix;

public class Matrix {

    private static boolean isMatrix(double[][] matrix) {
        int numOfRows = matrix.length;
        if (numOfRows == 0)
            return false;
        int numOfColumns = matrix[0].length;
        if (numOfColumns == 0)
            return false;
        for (int i = 1; i < numOfRows; i++)
            if (matrix[i].length != numOfColumns)
                return false;

        return true;
    }

    public static double[][] add(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        if (!isMatrix(firstMatrix) || !isMatrix(secondMatrix))
            throw new Exception("Input two-dimensional array is not matrix");
        if (firstMatrix.length != secondMatrix.length)
            throw new Exception("Number of matrices' rows doesn't match");
        if (firstMatrix[0].length != secondMatrix[0].length)
            throw new Exception("Number of matrices' columns doesn't match");

        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
            }
        }

        return result;
    }

    public static double[][] subtract(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        if (!isMatrix(firstMatrix) || !isMatrix(secondMatrix))
            throw new Exception("Input two-dimensional array is not matrix");
        if (firstMatrix.length != secondMatrix.length)
            throw new Exception("Number of matrices' rows doesn't match");
        if (firstMatrix[0].length != secondMatrix[0].length)
            throw new Exception("Number of matrices' columns doesn't match");

        double[][] result = new double[firstMatrix.length][firstMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[row][col] = firstMatrix[row][col] - secondMatrix[row][col];
            }
        }

        return result;
    }

    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        if (!isMatrix(firstMatrix) || !isMatrix(secondMatrix))
            throw new Exception("Input two-dimensional array is not matrix");
        if (firstMatrix[0].length != secondMatrix.length)
            throw new Exception("Number of first matrices' columns and second matrices' rows doesn't match");
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }

        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }

        return cell;
    }

    public static void print(double[][] matrix) throws Exception {
        if (!isMatrix(matrix))
            throw new Exception("Input two-dimensional array is not matrix");
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++)
                System.out.print(matrix[i][j]+ " ");
            System.out.println();
        }
    }


}
