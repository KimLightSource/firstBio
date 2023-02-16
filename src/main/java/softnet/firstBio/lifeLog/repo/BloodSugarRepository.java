package softnet.firstBio.lifeLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softnet.firstBio.lifeLog.Entity.BloodSugar;

public interface BloodSugarRepository extends JpaRepository<BloodSugar, Long> {

    @Query(value = "select * from blood_sugar bs order by  bs.created_date DESC LIMIT 1", nativeQuery = true)
    public BloodSugar latestBS();
}
