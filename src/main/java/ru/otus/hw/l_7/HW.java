package ru.otus.hw.l_7;

import java.util.Arrays;

public class HW {
    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {0, -5, 5}};
//        System.out.println(sumOfPositiveElements(arr));
//        System.out.println();

//        printSquare(4);
//        System.out.println();

//        int[][] arr2 = {{1, 2 ,3}, {4, 5, 6}, {7, 8, 9}};
//        nullifyDiagonals(arr2, MatrixDiagonals.MAIN);
//        nullifyDiagonals(arr2, MatrixDiagonals.SECONDARY);
//        nullifyDiagonals(arr2, MatrixDiagonals.BOTH);
//        print2DArray(arr2);

//        int[][] arr3 = {{1, 2, 3}};
//        System.out.println(secondElementSum(arr3, MatrixElements.ROW));
//        System.out.println(secondElementSum(arr2, MatrixElements.ROW));
//        System.out.println(secondElementSum(arr3, MatrixElements.COLUMN));
//        System.out.println(secondElementSum(arr2, MatrixElements.COLUMN));

//        System.out.println(findMax(arr));
//        System.out.println();
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void nullifyDiagonals(int[][] arr, MatrixDiagonals diagonalToNullify) {
        if (diagonalToNullify == MatrixDiagonals.MAIN) {
            int j = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i][j] = 0;
                j += 1;
            }
        }

        if (diagonalToNullify == MatrixDiagonals.SECONDARY) {
            int j = arr[0].length - 1;

            for (int i = 0; i < arr.length; i++) {
                arr[i][j] = 0;
                j -= 1;
            }
        }

        if (diagonalToNullify == MatrixDiagonals.BOTH) {
            int jMain = 0;
            int jSec = arr[0].length - 1;

            for (int i = 0; i < arr.length; i++) {
                arr[i][jMain] = 0;
                arr[i][jSec] = 0;

                jMain += 1;
                jSec -= 1;
            }
        }
    }

    public static int findMax(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        return max;
    }

    public static int secondElementSum(int[][] arr, MatrixElements element) {
        int sum = 0;

        if (element == MatrixElements.ROW) {
            if (arr.length < 2) {
                return -1;
            }

            int yCoord = 1;
            for (int x = 0; x < arr[yCoord].length; x++) {
                sum += arr[yCoord][x];
            }
        }

        if (element == MatrixElements.COLUMN) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length < 2) {
                    return -1;
                }
            }

            int xCoord = 1;
            for (int y = 0; y < arr.length; y++) {
                sum += arr[y][xCoord];
            }
        }

        return sum;
    }
}
