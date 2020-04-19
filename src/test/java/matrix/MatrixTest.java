package matrix;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MatrixTest {

    @ParameterizedTest
    @CsvSource({"0,5,add", "0,5,sub", "0,5,mult", "0,5,print", "5,0,add", "5,0,sub", "5,0,mult", "5,0,print"})
    void Throw_If_Matrix_Size_Incorrect(String _rows, String _columns, String op) {
        int rows = Integer.parseInt(_rows);
        int columns = Integer.parseInt(_columns);
        double firstMatrix[][] = new double[rows][columns];
        double secondMatrix[][] = new double[rows][columns];
        switch (op) {
            case "add" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.add(firstMatrix, secondMatrix); });
                break;
            }
            case "sub" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.subtract(firstMatrix, secondMatrix); });
                break;
            }
            case "mult" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.multiply(firstMatrix, secondMatrix); });
                break;
            }
            case "print" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.print(firstMatrix); });
                break;
            }
        }
    }

    @ParameterizedTest
    @CsvSource({"2,3,5,add", "2,3,5,sub",})
    void Throw_If_Number_Of_Matrices_Rows_Different(String _rowsFirst, String _rowsSecond, String _columns, String op) {
        int rowsFirst = Integer.parseInt(_rowsFirst);
        int rowsSecond = Integer.parseInt(_rowsSecond);
        int columns = Integer.parseInt(_columns);
        double firstMatrix[][] = new double[rowsFirst][columns];
        double secondMatrix[][] = new double[rowsSecond][columns];
        switch (op) {
            case "add" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.add(firstMatrix, secondMatrix); });
                break;
            }
            case "sub" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.subtract(firstMatrix, secondMatrix); });
                break;
            }
        }
    }

    @ParameterizedTest
    @CsvSource({"3,2,5,add", "3,3,5,sub",})
    void Throw_If_Number_Of_Matrices_Columns_Different(String _rows, String _columnsFirst, String _columnsSecond, String op) {
        int rows = Integer.parseInt(_rows);
        int columnsFirst = Integer.parseInt(_columnsFirst);
        int columnsSecond = Integer.parseInt(_columnsSecond);
        double firstMatrix[][] = new double[rows][columnsFirst];
        double secondMatrix[][] = new double[rows][columnsSecond];
        switch (op) {
            case "add" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.add(firstMatrix, secondMatrix); });
                break;
            }
            case "sub" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.subtract(firstMatrix, secondMatrix); });
                break;
            }
        }
    }

    @Test
    void Throw_If_In_Mult_Op_Matrices_Size_Incompatibility() {
        double firstMatrix[][] = new double[9][4];
        double secondMatrix[][] = new double[5][9];
        Assertions.assertThrows(Exception.class, () -> { Matrix.multiply(firstMatrix, secondMatrix); });
    }

    @ParameterizedTest
    @CsvSource({"add", "sub", "mult", "print",})
    void Throw_If_Two_Dims_Array_Is_Not_Matrix(String op) {
        double firstMatrix[][] = new double[2][];
        double secondMatrix[][] = new double[2][];
        firstMatrix[0] = new double[2];
        firstMatrix[1] = new double[3];
        secondMatrix[0] = new double[2];
        secondMatrix[1] = new double[3];
        switch (op) {
            case "add" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.add(firstMatrix, secondMatrix); });
                break;
            }
            case "sub" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.subtract(firstMatrix, secondMatrix); });
                break;
            }
            case "mult" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.multiply(firstMatrix, secondMatrix); });
                break;
            }
            case "print" : {
                Assertions.assertThrows(Exception.class, () -> { Matrix.print(firstMatrix); });
                break;
            }
        }
    }

    @Test
    void Add_Test() throws Exception {
        double[][] firstMatrix = {
            {2, 3, 4},
            {5, 6, 7}
        };
        double[][] secondMatrix = {
            {8, 9, 10},
            {11, 12, 13}
        };
        double[][] expected = {
            {10, 12, 14},
            {16, 18, 20}
        };
        double actual[][] = Matrix.add(firstMatrix, secondMatrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Sub_Test() throws Exception {
        double[][] firstMatrix = {
            {2, 3},
            {4, 5},
            {6, 7}
        };
        double[][] secondMatrix = {
            {8, 9},
            {10, 11},
            {12, 13}
        };
        double[][] expected = {
            {-6, -6},
            {-6, -6},
            {-6, -6}
        };
        double actual[][] = Matrix.subtract(firstMatrix, secondMatrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Mult_Test() throws Exception {
        double[][] firstMatrix = {
                {2, 3},
                {4, 5},
                {6, 7}
        };
        double[][] secondMatrix = {
                {8, 9, 10},
                {11, 12, 13}
        };
        double[][] expected = {
                {49, 54, 59},
                {87, 96, 105},
                {125, 138, 151}
        };
        double actual[][] = Matrix.multiply(firstMatrix, secondMatrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void Print_Test() throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        double[][] matirx = {
                {10, 12, 14},
                {16, 18, 20}
        };
        System.setOut(new PrintStream(out));
        Matrix.print(matirx);
        String expected = "10.0 12.0 14.0 \r\n16.0 18.0 20.0 \r\n";
        Assertions.assertEquals(expected, out.toString());
    }



}