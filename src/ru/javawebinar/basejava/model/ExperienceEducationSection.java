package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class ExperienceEducationSection extends Section {
    private final List<ExperienceEducation> list;

    public ExperienceEducationSection(List<ExperienceEducation> list) {
        this.list = list;
    }

    public List<ExperienceEducation> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceEducationSection that = (ExperienceEducationSection) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
    @Override
    public String toString() {
        String str = "";
        StringBuilder sb = new StringBuilder(str);
        for (ExperienceEducation arr : list) {
            sb.append(arr);
            sb.append("\n");
        }
        return sb.toString();
    }

}
