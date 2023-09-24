package ru.otus.hw.l15;

import java.util.ArrayList;
import java.util.List;

public class HW {
    public static void main(String[] args) {
//        System.out.println(buildListFromRange(3, 7));
//        System.out.println(sumList(new ArrayList<>(List.of(6, 3, 6))));

//        List<Integer> list = new ArrayList<>(List.of(0, 0, 0));
//        System.out.println(list);
//        fillList(5, list);
//        System.out.println(list);
//        addToListElements(1, list);
//        System.out.println(list);


        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee("Mike", 30),
                        new Employee("Helen", 20)
                )
        );
//        System.out.println(Employee.getNames(employees));
//        System.out.println(Employee.filterByAge(employees, 25));
//        System.out.println(Employee.checkAvgAgeCorrespondence(employees, 26));
        System.out.println(Employee.getYoungest(employees));
    }

    public static List<Integer> buildListFromRange(int min, int max) {
        List<Integer> list = new ArrayList<>();

        for (int i = min; i <= max ; i++) {
            list.add(i);
        }

        return list;
    }

    public static int sumList(List<Integer> list) {
        int sum = 0;

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) > 5) {
//                sum += list.get(i);
//            }
//        }
        // =>
        for (Integer el : list) {
            if (el > 5) {
                sum += el;
            }
        }

        return sum;
    }

    public static void fillList(int value, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    public static void addToListElements(int val, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + val);
        }
    }

}
