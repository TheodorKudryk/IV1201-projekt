package com.iv1201.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author leohj
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*
    @Bean
    PasswordEncoder bcryptPasswordEndoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().withUser("leo").password(encoder.encode("user1")).roles("ADMIN");
    }
    */
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/loginAttempt");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/**").permitAll()
                .anyRequest()
                    .authenticated()
                .and()//.httpBasic();
                    .formLogin()
                    .loginPage("/login")//.usernameParameter("username").passwordParameter("password")
                        //.defaultSuccessUrl("/hello",true)
                    .permitAll();
    }
}
