package ourbusinessproject;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Size(min = 10)
    @Column(length = 2000)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String contactName;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String contactEmail;

    @JsonIgnore // is used to ignore the projects property when serializing the Enterprise
                // object to JSON
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    public Enterprise(String name, String description, String contactName, String contactEmail) {
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

    public String getName() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        if (projects != null) {
            projects.sort(Comparator.comparing(Project::getTitle));
        }
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
