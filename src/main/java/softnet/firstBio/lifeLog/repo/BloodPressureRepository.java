package softnet.firstBio.lifeLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softnet.firstBio.lifeLog.Entity.BloodPressure;

@Repository
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {
}
