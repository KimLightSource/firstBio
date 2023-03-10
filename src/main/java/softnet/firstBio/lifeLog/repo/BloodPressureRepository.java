package softnet.firstBio.lifeLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softnet.firstBio.lifeLog.Entity.BloodPressure;

@Repository
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {

    @Query(value = "select * from blood_pressure bp order by  bp.created_date DESC LIMIT 1", nativeQuery = true)
    BloodPressure latestBP();

}
