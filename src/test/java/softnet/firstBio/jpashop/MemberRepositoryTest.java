package softnet.firstBio.jpashop;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.repo.BloodPressureRepository;

import java.time.Duration;
import java.util.Date;

@DataJpaTest
class MemberRepositoryTest {

    @Test
    public void makeJwtToken() {
        Date now = new Date();

        System.out.println(Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
                .setIssuer("fresh") // (2)
                .setIssuedAt(now) // (3)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) // (4)
                .claim("id", "아이디") // (5)
                .claim("email", "qkek875@gmail.com")
                .signWith(SignatureAlgorithm.HS256, "secret") // (6)
                .compact());
    }
}