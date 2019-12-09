package ru.javawebinar.basejava.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ExperienceEducation extends Section {
    private final Link link;
    private final Date firstDate;
    private final Date lastDate;
    private final String text;
    private String name = null;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");

    public ExperienceEducation(String link, String startDate, String endDate, String text, String name) {
          this(link,startDate,endDate,text);
          this.name = name;
       /* Objects.requireNonNull(startDate, "uuid must not be null");
        Objects.requireNonNull(endDate, "uuid must not be null");
        Objects.requireNonNull(text, "uuid must not be null");
        Objects.requireNonNull(name, "uuid must not be null");
        this.link = new Link(link);
        this.name = name;
        Date firstDate = null;
        Date lastDate = null;
        try {
            firstDate = simpleDateFormat.parse(startDate);
            lastDate = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat.format(firstDate);
        simpleDateFormat.format(lastDate);
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.text = text;*/
    }

    public ExperienceEducation(String link, String startDate, String endDate, String text) {
        Objects.requireNonNull(startDate, "uuid must not be null");
        Objects.requireNonNull(endDate, "uuid must not be null");
        Objects.requireNonNull(text, "uuid must not be null");
        this.link = new Link(link);
        Date firstDate = null;
        Date lastDate = null;
        try {
            firstDate = simpleDateFormat.parse(startDate);
            lastDate = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat.format(firstDate);
        simpleDateFormat.format(lastDate);
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.text = text;
    }

    public Link getLink() {
        return link;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }


    public String getText() {
        return text;
    }

    public String getName() {
        return name;
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
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, firstDate, lastDate, text, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (name != null) {
            return sb.append(link).append("\n").append(simpleDateFormat.format(firstDate)).append("\n").append(simpleDateFormat.format(lastDate))
                    .append("\n").append(name).append("\n").append(text).toString();
        } else
            return sb.append(link).append("\n").append(simpleDateFormat.format(firstDate)).append("\n").append(simpleDateFormat.format(lastDate))
                    .append("\n").append(text).toString();
    }
}
