package shuaicj.hello.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Test simple http authentication.
 *
 * @author shuaicj 2016/12/28
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("shuaicj").password("shuaicj").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/hello").permitAll()
//                .anyRequest().hasRole("USER")
//                .and()
//            .httpBasic();
//        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }
}

