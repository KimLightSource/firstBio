package softnet.firstBio.lifeLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softnet.firstBio.lifeLog.Entity.member.Member;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUid(String id);


}