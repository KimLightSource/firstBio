package softnet.firstBio.lifeLog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import softnet.firstBio.lifeLog.config.auth.filter.JWTCheckfilter;
import softnet.firstBio.lifeLog.config.auth.filter.JWTLoginFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityConfig extends WebSecurityConfigurerAdapter {
    final UserDetailsService userDetailsService;
    final ObjectMapper objectMapper;

    private static final String[] AUTH_WHITELIST = {
            "/**"
    };

    private static final String[] AUTH_ADMIN = {
            "/admin/**",
            "/ai/inner/**",
            "/biometric/**",
            "/code/**",
            "/faq/**",
            "/inquiry/**",
            "/location/**",
            "/notice/**",
            "/patient/**",
            "/request/**",
            "/survey/**",
            "/term/**",
    };

    private static final String[] AI_AUTHLIST = {
            "/ai/outer/**"
    };

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final JWTLoginFilter loginFilter = new JWTLoginFilter(authenticationManager(), objectMapper);
        final JWTCheckfilter checkFilter = new JWTCheckfilter(authenticationManager(), userDetailsService);

        http.cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .authorizeRequests(request -> request
                        .antMatchers(AUTH_WHITELIST).permitAll()
                        .anyRequest().authenticated())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAt(loginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(checkFilter, BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addExposedHeader(HttpHeaders.AUTHORIZATION);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Bean
//    public RoleHierarchyImpl roleHierarchy(){
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy(userDetailsService.getRoleHierarchy());
//        return roleHierarchy;
//    }

//    @Bean
//    public AccessDecisionVoter roleVoter(){
//        RoleHierarchyVoter roleHierarchyVoter = new RoleHierarchyVoter(roleHierarchy());
//        return roleHierarchyVoter;
//    }
}
