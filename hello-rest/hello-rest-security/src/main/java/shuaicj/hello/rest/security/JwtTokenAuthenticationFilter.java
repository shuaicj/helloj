package shuaicj.hello.rest.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Collections.emptyList;

/**
 * Authenticate requests with header 'Authorization: Bearer jwt-token'.
 *
 * @author shuaicj 2017/05/12
 */
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtAuthenticationConfig config;

    public JwtTokenAuthenticationFilter(JwtAuthenticationConfig config) {
        this.config = config;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse rsp, FilterChain filterChain)
            throws ServletException, IOException {
        String token = req.getHeader(config.getHeader());
        if (token != null && token.startsWith(config.getPrefix() + " ")) {
            token = token.replace(config.getPrefix() + " ", "");
            UsernamePasswordAuthenticationToken auth = null;
            try {
                String user = Jwts.parser()
                        .setSigningKey(config.getSecret())
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
                if (user != null) {
                    auth = new UsernamePasswordAuthenticationToken(user, null, emptyList());
                }
            } catch (JwtException ignore) {}
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(req, rsp);
    }
}
