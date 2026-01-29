package ourbusinessproject;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Partnership {
    @NotNull
    private Project project;
    @NotNull
    private Enterprise enterprise;
    @NotNull
    private Date creationDate;

    public Partnership(Project project, Enterprise enterprise, Date creationDate) {
        this.project = project;
        this.enterprise = enterprise;
        this.creationDate = creationDate;
    }

    public Partnership() {}

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
