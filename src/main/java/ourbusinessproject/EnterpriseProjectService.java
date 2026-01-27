package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {
    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService() {
    }

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Project newProject(String title, String description, Enterprise enterprise) {
        Project project = new Project(title, description);
        project.setEnterprise(enterprise);
        entityManager.persist(project);
        entityManager.flush();
        return project;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail) {
        Enterprise enterprise = new Enterprise(name, description, contactName, contactEmail);
        entityManager.persist(enterprise);
        entityManager.flush();
        return enterprise;
    }

    public Project findProjectById(Long id) {
        return entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id) {
        return entityManager.find(Enterprise.class, id);
    }
}
