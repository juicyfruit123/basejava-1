package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Link {
    private final String url;
    private final String name;

    public Link(String url, String name) {
        Objects.requireNonNull(url, "uuid must not be null");
        Objects.requireNonNull(name, "uuid must not be null");
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(url, link.url) &&
                Objects.equals(name, link.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, name);
    }

    @Override
    public String toString() {
        return  url +" "+ name;
    }
}
