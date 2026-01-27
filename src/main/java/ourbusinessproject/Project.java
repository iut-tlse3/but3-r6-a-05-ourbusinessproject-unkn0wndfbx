package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;

public class Project {
    @NotBlank
    private String title;

    private String description;

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Project() {
        this.title = "default title";
        this.description = "default description";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
