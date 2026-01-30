package ourbusinessproject;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PartnershipService {
    @PersistenceContext
    private EntityManager entityManager;

    public PartnershipService() {
    }

    public PartnershipService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public Partnership newPartnership(Project project, Enterprise partnerEnterprise) {
        Partnership partnership = new Partnership(project, partnerEnterprise, new Date());
        entityManager.persist(partnership);
        entityManager.flush();
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        return entityManager.find(Partnership.class, id);
    }

    @Transactional
    public void remove(Partnership partnership) {
        entityManager.remove(partnership);
    }
}
