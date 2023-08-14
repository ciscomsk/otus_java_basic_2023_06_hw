package ru.otus.hw.l_3;

import java.util.Random;
import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        int userChoice = getMethodNumber();
        executeMethod(userChoice);
    }

    public static void greetings() {
        System.out.print("Hello\nWorld\nFrom\nJava");
    }

    public static void checkSign(int val1, int val2, int val3) {
        System.out.println("val1 = " + val1 + ", val2 = " + val2 + ", val3 = " + val3);
        long sum = val1 + val2 + val3;
        System.out.println(sum);

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor(int data) {
        System.out.println("data = " + data);

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static int getMethodNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter method number: ");
        return sc.nextInt();
    }

    public static void compareNumbers(int val1, int val2) {
        System.out.println("val1 = " + val1 + ", val2 = " + val2);

        if (val1 >= val2) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("initValue = " + initValue + ", delta = " + delta + ", increment = " + increment);

        long res = (increment) ? initValue + delta : initValue - delta;
        System.out.println(res);
    }

    public static void executeMethod(int methodNumer) {
        Random rnd = new Random();

        switch (methodNumer) {
            case 1 -> greetings();
            case 2 -> {
                int val1 = rnd.nextInt();
                int val2 = rnd.nextInt();
                int val3 = rnd.nextInt();
                checkSign(val1, val2, val3);
            }
            case 3 -> {
                int data = rnd.nextInt(30);
                selectColor(data);
            }
            case 4 -> {
                int val1 = rnd.nextInt();
                int val2 = rnd.nextInt();
                compareNumbers(val1, val2);
            }
            case 5 -> {
                int initValue = rnd.nextInt();
                int delta = rnd.nextInt();
                boolean increment = rnd.nextBoolean();
                addOrSubtractAndPrint(initValue, delta, increment);
            }
            default -> System.out.println("Unknown method number");
        }
    }
}
