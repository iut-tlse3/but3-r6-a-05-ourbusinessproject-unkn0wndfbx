package ourbusinessproject;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "partnerships")
public class Partnership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    private Project project;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    @NotNull
    private Enterprise enterprise;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date creationDate;

    public Partnership(Project project, Enterprise enterprise, Date creationDate) {
        this.project = project;
        this.enterprise = enterprise;
        this.creationDate = creationDate;
    }

    public Partnership() {
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Enterprise getEnterprise() {
        return this.enterprise;
    }

    public Project getProject() {
        return this.project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
