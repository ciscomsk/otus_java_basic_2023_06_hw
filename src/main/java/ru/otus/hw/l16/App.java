package ru.otus.hw.l16;

public class App {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Mike", 911_111_11_11L);
        pb.add("Mike", 911_111_11_11L);
        pb.add("Mike", 922_222_22_22L);
        pb.add("Helen", 933_333_33_33L);

        System.out.println(pb);
        System.out.println(pb.find("Mike"));
        System.out.println(pb.find("Kalvin"));
        System.out.println(pb.containsPhoneNumber(911_111_11_11L));
        System.out.println(pb.containsPhoneNumber(900_000_00_00L));
    }
}
