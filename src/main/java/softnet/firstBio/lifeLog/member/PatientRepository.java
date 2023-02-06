package softnet.firstBio.lifeLog.member;

import org.springframework.stereotype.Repository;
import softnet.firstBio.lifeLog.Entity.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PatientRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Patient patient) {
        em.persist(patient);
        return patient.getId();
    }

    public Patient find(Long id) {
        return em.find(Patient.class, id);
    }

}