package ru.otus.hw.l16;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<Long>> records;

    public PhoneBook() {
        this.records = new HashMap<>();
    }

    @Override
    public String toString() {
        return "PhoneBook{" + records + "}";
    }

    public Map<String, Set<Long>> getRecords() {
        return records;
    }

    public void add(String name, long phone) {
        boolean recordExist = records.containsKey(name);

        if (recordExist) {
            records.get(name).add(phone);
        } else {
            Set<Long> phones = new HashSet<>();
            phones.add(phone);
            records.put(name, phones);
        }
    }

    public Set<Long> find(String name) {
        return records.get(name);
    }

    public boolean containsPhoneNumber(long phone) {
        Collection<Set<Long>> values = records.values();

        for (Set<Long> set : values) {
            if (set.contains(phone)) {
                return true;
            }
        }

        return false;
    }
}
