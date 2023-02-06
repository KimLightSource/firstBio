package softnet.firstBio.lifeLog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import softnet.firstBio.lifeLog.Entity.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MemberController {

    @PersistenceContext
    private EntityManager em;

    public Patient find(
            @RequestBody Patient member
    ) {
        return em.find(Patient.class, member);
    }
}
