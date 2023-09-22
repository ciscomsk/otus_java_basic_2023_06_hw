package ru.otus.hw.l_14;

public class App {
    public static void main(String[] args) {
        String[][] arr = {
//                {"1", "2", "3"},
//                {"1", "2", "str", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        System.out.println(sumStringArray(arr));
    }

    public static int sumStringArray(String[][] arr) {
        int sum = 0;
        if (arr.length != 4) {
            throw new AppArraySizeException("Array must be 4 x 4 in size");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new AppArraySizeException("Array must be 4 x 4 in size");
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new AppArrayDataException("Cell [" + i + "][" + j + "] contains invalid value");
                }
            }
        }

        return sum;
    }
}
