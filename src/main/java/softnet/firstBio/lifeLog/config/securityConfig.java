package softnet.firstBio.lifeLog.config;

import com.google.firebase.auth.FirebaseAuth;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import softnet.firstBio.lifeLog.config.auth.AuthFilterContainer;
import softnet.firstBio.lifeLog.config.auth.filter.JwtFilter;
import softnet.firstBio.lifeLog.service.MemberServiceImpl;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class securityConfig extends WebSecurityConfigurerAdapter {

    private final AuthFilterContainer authFilterContainer;

    private final MemberServiceImpl memberService;
    private final FirebaseAuth firebaseAuth;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable() // rest api 만을 고려하여 기본 설정은 해제
                .csrf().disable() // csrf 보안 토큰 disable 처리.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // 요청에 대한 권한 지정
                .anyRequest().authenticated() // 모든 요청이 인증되어야한다.

                .and()
                .cors(httpSecurityCorsConfigurer -> this.corsConfigurationSource())
                .addFilterBefore(new JwtFilter(memberService, firebaseAuth),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    //인증 예외 URL 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/static/**")
                .antMatchers("/js/**")
                .antMatchers("/img/**")
                .antMatchers("/fonts/**")
                .antMatchers("/vendor/**")
                .antMatchers("/favicon.ico")
                .antMatchers("/pages/**")
                .antMatchers("/member");
    }
}
