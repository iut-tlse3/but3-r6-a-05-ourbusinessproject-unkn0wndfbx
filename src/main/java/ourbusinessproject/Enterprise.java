package ourbusinessproject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Enterprise {
    @NotBlank
    private String name;
    @Size(min = 10)
    private String description;
    @NotBlank
    private String contactName;
    @NotBlank
    @Email
    private String contactEmail;

    public Enterprise(String name, String description,  String contactName, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public Enterprise() {
        this.name = "default name";
        this.description = "default description";
        this.contactName = "default contact name";
        this.contactEmail = "default contact email";
    }

    public String getTitle() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContactName() {
        return contactName;
    }
    public String getContactEmail() {
        return contactEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
