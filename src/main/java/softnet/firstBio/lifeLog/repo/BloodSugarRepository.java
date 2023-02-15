package softnet.firstBio.lifeLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import softnet.firstBio.lifeLog.Entity.BloodSugar;

public interface BloodSugarRepository extends JpaRepository<BloodSugar, Long> {
}
