package ru.otus.hw.l21;

import java.util.ArrayList;
import java.util.List;

public class HW {
    public static void main(String[] args) {
        Measure.stamp();
        singleThread();
        Measure.print();

        Measure.stamp();
        fourThread();
        Measure.print();
    }

    public static void singleThread() {
        double[] arr = new double[100_000_000];
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    public static void fourThread() {
        double[] arr = new double[100_000_000];
        int partitionSize = 25_000_000;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int part = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    for (int j = part * partitionSize; j < (part + 1) * partitionSize; j++) {
                        arr[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                    }
                }
            });

            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
