package softnet.firstBio.lifeLog.service;

import softnet.firstBio.lifeLog.Entity.Patient;

public interface PatientService {
    void createPatient(Patient patient);

    Patient getPatient(Long id);

}
