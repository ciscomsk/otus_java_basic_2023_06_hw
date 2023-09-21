package ru.otus.hw.l_5;

import java.util.Arrays;

public class HW {
    public static void main(String[] args) {
//        printNTimes("AAA", 3);
//        System.out.println();

//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        sumArrayElementsAndPrint(arr);
//        System.out.println();

//        fillArray(arr, 5);
//        printArray(arr);
//        System.out.println();

//        printArray(arr);
//        System.out.println();

//        int[] arr2 = {5, 4, 3, 2, 1};
//        int[] arr3 = {1, 2, 3, 4, 5, 6};
//        compareArrayHalves(arr2);
//        compareArrayHalves(arr3);
//        System.out.println();

//        printArray(sumArrays(arr, arr2, arr3));
//        System.out.println();

//        System.out.println(checkElementsOrder(arr, SortOrder.ASC));
//        System.out.println(checkElementsOrder(arr2, SortOrder.DESC));

//        int[] arr4 = {1, 1, 1, 1, 1, 5};
//        int[] arr5 = {5, 3, 4, -2};
//        int[] arr6 = {7, 2, 2, 2};
//        System.out.println(checkEqualityIndex(arr4));
//        System.out.println(checkEqualityIndex(arr5));
//        System.out.println(checkEqualityIndex(arr6));

//        revertArray(arr2);
//        printArray(arr2);
//        revertArray(arr3);
//        printArray(arr3);
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printNTimes(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public static void sumArrayElementsAndPrint(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }

    public static void fillArray(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }

    public static void addToArrayElements(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += value;
        }
    }

    public static void compareArrayHalves(int[] arr) {
        int leftHalf = 0, rightHalf = 0;

        // for arrays with an odd number of elements, we assume that the middle element belongs to both halves
        int oddArrModifier = (arr.length % 2 == 0) ? 0 : 1;

        for (int i = 0; i < arr.length / 2 + oddArrModifier; i++) {
            leftHalf += arr[i];
        }

        for (int i = arr.length / 2; i < arr.length ; i++) {
            rightHalf += arr[i];
        }

        if (leftHalf > rightHalf) {
            System.out.println("Left half " + leftHalf + " > right half " + rightHalf);
        } else {
            System.out.println("Right half " + rightHalf + " > light half " + leftHalf);
        }
    }


    public static int[] sumArrays(int[] ...arrays) {
        int maxArrLength = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > maxArrLength) {
                maxArrLength = arrays[i].length;
            }
        }

        int[] resultArray = new int[maxArrLength];

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                resultArray[j] += arrays[i][j];
            }
        }

        return resultArray;
    }

    public static boolean checkElementsOrder(int[] arr, SortOrder order) {
        boolean result = true;
        int prevEl = arr[0];

        if (order == SortOrder.ASC) {
            for (int i = 1; i < arr.length; i++) {
                if (prevEl >= arr[i]) {
                    result = false;
                    break;
                }
                prevEl = arr[i];
            }
        }

        if (order == SortOrder.DESC) {
            for (int i = 1; i < arr.length; i++) {
                if (prevEl <= arr[i]) {
                    result = false;
                    break;
                }
                prevEl = arr[i];
            }
        }

        return result;
    }

    public static int checkEqualityIndex(int[] arr) {
        int equalityPointIndex = -1;
        int leftHalfSum = 0, rightHalfSum = 0;

        for (int i = 0; i < arr.length; i++) {
            leftHalfSum += arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                rightHalfSum += arr[j];
            }

            if (leftHalfSum == rightHalfSum) {
                equalityPointIndex = i;
                break;
            }

            rightHalfSum = 0;
        }

        return equalityPointIndex;
    }

    public static void revertArray(int[] arr) {
        int temp, mirrorIndex;

        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            mirrorIndex = arr.length - 1 - i;

            arr[i] = arr[mirrorIndex];
            arr[mirrorIndex] = temp;
        }
    }
}
