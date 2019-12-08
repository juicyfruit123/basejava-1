package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class AchievementQualifications extends Section {
    private final List<String> text;

    public AchievementQualifications(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementQualifications that = (AchievementQualifications) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        String str = "";
        StringBuilder sb = new StringBuilder(str);
        for (String arr : text) {
            sb.append(arr);
            sb.append("\n");
        }
        return sb.toString();
    }
}
