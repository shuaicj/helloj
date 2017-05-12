package shuaicj.hello.rest.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;

/**
 * Authenticate the request to url /auth by POST with json body '{ username, password }'.
 * If successful, response the client with header 'Authorization: Bearer jwt-token'.
 *
 * @author shuaicj 2017/05/12
 */
public class JwtUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtAuthenticationConfig config;

    public JwtUsernamePasswordAuthenticationFilter(JwtAuthenticationConfig config, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(config.getUrl(), "POST"));
        this.config = config;
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse rsp)
            throws AuthenticationException, IOException, ServletException {
        User u = new ObjectMapper().readValue(req.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                u.getUsername(), u.getPassword(), Collections.emptyList()
        ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse rsp, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(auth.getName())
                .setExpiration(Date.from(Instant.now().plusSeconds(config.getExpiration())))
                .signWith(SignatureAlgorithm.HS512, config.getSecret())
                .compact();
        rsp.addHeader(config.getHeader(), config.getPrefix() + " " + token);
    }

    @Getter
    @Setter
    private static class User {
        private String username, password;
    }
}
