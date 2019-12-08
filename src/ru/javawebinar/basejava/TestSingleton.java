package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.SectionType;

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
        Map<SectionType, String> map = new EnumMap<>(SectionType.class);

        for (Map.Entry<SectionType, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public enum Singleton {
        INSTANCE
    }
}
