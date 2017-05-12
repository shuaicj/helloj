package shuaicj.hello.rest.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implement AuthenticationEntryPoint.
 *
 * @author shuaicj 2017/05/12
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse rsp, AuthenticationException authException)
            throws IOException, ServletException {
        rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
