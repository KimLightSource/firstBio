package softnet.firstBio.jpashop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.repo.BloodPressureRepository;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    BloodPressureRepository bpr;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given


        //when

        BloodPressure bo = bpr.latestBP();

        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("bo = " + bo);
    }
}