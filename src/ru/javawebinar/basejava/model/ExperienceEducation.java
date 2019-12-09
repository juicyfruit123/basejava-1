package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class ExperienceEducation {
    private final Link link;
    private final LocalDate firstDate;
    private final LocalDate lastDate;
    private final String text;
    private String description = null;

    public ExperienceEducation(String link, LocalDate firstDate, LocalDate lastDate, String text, String description) {
        this(link, firstDate, lastDate, text);
        this.description = description;
    }

    public ExperienceEducation(String link, LocalDate firstDate, LocalDate lastDate, String text) {
        Objects.requireNonNull(firstDate, "uuid must not be null");
        Objects.requireNonNull(lastDate, "uuid must not be null");
        Objects.requireNonNull(text, "uuid must not be null");
        this.link = new Link(link);
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.text = text;
    }

    public Link getLink() {
        return link;
    }

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceEducation that = (ExperienceEducation) o;
        return Objects.equals(link, that.link) &&
                Objects.equals(firstDate, that.firstDate) &&
                Objects.equals(lastDate, that.lastDate) &&
                Objects.equals(text, that.text) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, firstDate, lastDate, text, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (description != null) {
            return sb.append(link).append("\n").append(firstDate).append("\n").append(lastDate)
                    .append("\n").append(description).append("\n").append(text).toString();
        } else
            return sb.append(link).append("\n").append(firstDate).append("\n").append(lastDate)
                    .append("\n").append(text).toString();
    }
}
