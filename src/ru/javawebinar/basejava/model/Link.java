package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Link {
    private final String url;

    public Link(String url) {
        Objects.requireNonNull(url, "uuid must not be null");
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(url, link.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return url;
    }
}
