package com.safonov.speedreading.main.fragment.recommendation.model;

public class Recommendation {
    private String description;
    private String link;
    private String title;

    public Recommendation(String title2, String description2, String link2) {
        this.title = title2;
        this.description = description2;
        this.link = link2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link2) {
        this.link = link2;
    }
}
