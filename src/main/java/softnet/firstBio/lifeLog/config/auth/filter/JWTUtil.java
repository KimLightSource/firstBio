package softnet.firstBio.lifeLog.config.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import softnet.firstBio.lifeLog.Entity.member.Member;

import java.time.Instant;

@Component
public class JWTUtil {
    private static final long AUTH_TIME = 7*24*60*60;
    private static Algorithm ALGORITHM;

    @Value("${JWT_SECRET}")
    public void setAlgorithm(String secretKey) {
        ALGORITHM = Algorithm.HMAC256(secretKey);
    }

    public static String makeAuthToken(Member member) {
        return JWT.create()
                .withSubject(member.getUid())
                .withClaim("exp", Instant.now().getEpochSecond()+AUTH_TIME)
                .sign(ALGORITHM);
    }

    public static VerifyResult verify(String token) {
        try{
            DecodedJWT verify = JWT.require(ALGORITHM).build().verify(token);
            return VerifyResult.builder().success(true)
                    .loginId(verify.getSubject())
                    .build();
        } catch (Exception ex){
            DecodedJWT decode = JWT.decode(token);
            return VerifyResult.builder().success(false)
                    .loginId(decode.getSubject())
                    .build();
        }
    }
}
