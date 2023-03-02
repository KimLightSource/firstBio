package softnet.firstBio.lifeLog.config.auth;

import com.google.firebase.auth.FirebaseAuth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import softnet.firstBio.lifeLog.config.auth.filter.JwtFilter;
import softnet.firstBio.lifeLog.config.auth.filter.MockJwtFilter;
import softnet.firstBio.lifeLog.service.MemberServiceImpl;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class AuthConfig {

    private final MemberServiceImpl memberService;
    private final FirebaseAuth firebaseAuth;

    @Bean
    @Profile("local")
    AuthFilterContainer mockAuthFilter() {
        log.info("local AuthFilter 초기화");
        AuthFilterContainer authFilterContainer = new AuthFilterContainer();
        authFilterContainer.setAuthFilter(new MockJwtFilter(memberService));
        return authFilterContainer;
    }

    @Bean
    @Profile("prod")
    public AuthFilterContainer firebaseAuthFilter() {
        log.info("Firebase AuthFilter 초기화");
        AuthFilterContainer authFilterContainer = new AuthFilterContainer();
        authFilterContainer.setAuthFilter(new JwtFilter(memberService, firebaseAuth));
        return authFilterContainer;
    }
}
