package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.SectionType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
/*
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }*/

        String d = "08/2016";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
        try {
            Date date = simpleDateFormat.parse(d);
            System.out.println(simpleDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public enum Singleton {
        INSTANCE
    }
}
