package ru.javawebinar.basejava.model;

public enum ContactType {
    TELEPHONE("Тел."),
    SKYPE("СКАЙП"),
    MAIL("ПОЧТА"),
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
