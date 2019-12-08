package ru.javawebinar.basejava.model;

public enum ContactType {
    TELEPHONE (""),
    SKYPE(""),
    MAIL(""),
    LINKEDIN(""),
    GITHUB(""),
    STACKOVERFLOW(""),
    HOMEPAGE("");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
