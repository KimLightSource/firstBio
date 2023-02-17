package softnet.firstBio.lifeLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softnet.firstBio.lifeLog.Entity.Weight;

@Repository
public interface WeightRepository  extends JpaRepository<Weight, Long> {
    @Query(value = "select * from weight w order by w.created_date DESC LIMIT 1", nativeQuery = true)
    public Weight latestWeight();
}
