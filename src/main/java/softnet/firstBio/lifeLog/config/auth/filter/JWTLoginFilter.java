package softnet.firstBio.lifeLog.config.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import softnet.firstBio.lifeLog.Entity.member.Member;
import softnet.firstBio.lifeLog.dto.MemberLoginDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    final ObjectMapper objectMapper;

    public JWTLoginFilter(
            AuthenticationManager authenticationManager,
            ObjectMapper objectMapper) {
        super(authenticationManager);
        this.objectMapper = objectMapper;
        setFilterProcessesUrl("/member/login");
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException
    {
        MemberLoginDto login = objectMapper.readValue(request.getInputStream(), MemberLoginDto.class);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                login.getUid(), login.getPassword(), null
        );

        token.setDetails(login);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException
    {
        var loginUser = (Member) authResult.getPrincipal();
        MemberLoginDto tokenDetail = (MemberLoginDto) authResult.getDetails();
        tokenDetail.setUid(loginUser.getUid());

        request.setAttribute("loginUser", tokenDetail);

        response.setHeader(HttpHeaders.AUTHORIZATION, JWTUtil.makeAuthToken((Member) authResult.getPrincipal()));
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
