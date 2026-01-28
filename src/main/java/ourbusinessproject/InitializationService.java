package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// @Service is used to mark the class as a service: singleton to be injected into the Bootstrap
@Service
public class InitializationService {
    // @Autowired is used to inject the EnterpriseProjectService into the
    // InitializationService
    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    // @Transactional is used to ensure that the transaction is rolled back if an
    // error occurs
    @Transactional
    public void initProjects() {
        enterprise1 = enterpriseProjectService.newEnterprise(
                "Enterprise 1",
                "Description entreprise 1",
                "Contact 1",
                "contact1@enterprise1.com");
        enterprise2 = enterpriseProjectService.newEnterprise(
                "Enterprise 2",
                "Description entreprise 2",
                "Contact 2",
                "contact2@enterprise2.com");

        project1E1 = enterpriseProjectService.newProject(
                "a",
                "Description projet a",
                enterprise1);
        project1E2 = enterpriseProjectService.newProject(
                "b",
                "Description projet b",
                enterprise2);
        project2E1 = enterpriseProjectService.newProject(
                "c",
                "Description projet c",
                enterprise1);

        // Avec @Transactional, si une exception se produit, toute la transaction
        // est annulée (rollback). Même si les entreprises et projets précédents ont été créés,
        // ils seront tous annulés.
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
