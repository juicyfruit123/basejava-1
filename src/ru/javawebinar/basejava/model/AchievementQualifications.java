package ru.javawebinar.basejava.model;

import java.util.Arrays;

public class AchievementQualifications {
    private final String[] text;

    public AchievementQualifications(String[] text) {
        this.text = text;
    }

    public String[] getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementQualifications that = (AchievementQualifications) o;
        return Arrays.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(text);
    }

    @Override
    public String toString() {
        return "AchievementQualifications{" +
                "text=" + Arrays.toString(text) +
                '}';
    }
}
