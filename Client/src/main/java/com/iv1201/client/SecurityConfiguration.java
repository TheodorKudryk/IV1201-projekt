package com.iv1201.client;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author leohj
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    
    @Bean
    PasswordEncoder bcryptPasswordEndoder() {
        return new BCryptPasswordEncoder();
    }
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("anropar");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().withUser("leo").password(encoder.encode("user1")).roles("ADMIN");
        UsernamePasswordAuthenticationToken u;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("anropar");
        auth.authenticationProvider(DaoAuthenticationProvider());
    }
    
    @Bean
    DaoAuthenticationProvider DaoAuthenticationProvider(){
        DaoAuthenticationProvider DaoAuthenticationProvider = new DaoAuthenticationProvider();
        
        DaoAuthenticationProvider.setPasswordEncoder(bcryptPasswordEndoder());
        
        DaoAuthenticationProvider.setUserDetailsService(new CustomUserDetailsService());
        
        return DaoAuthenticationProvider;
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/loginAttempt");
    }
    
     @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user1").password(bcryptPasswordEndoder().encode("user1Pass")).roles("USER")
            .and()
            .withUser("user2").password(bcryptPasswordEndoder().encode("user2Pass")).roles("USER")
            .and()
            .withUser("admin").password(bcryptPasswordEndoder().encode("adminPass")).roles("ADMIN");
    }
    */
    
    @Override
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new CustomAuthenticationProvider());
    }
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers("/hi").hasAnyRole("USER","ADMIN")
                .antMatchers("/login*","/startpage", "/hi").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginAttempt")
                .defaultSuccessUrl("/hi", true)
                .failureUrl("/login")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
    }

}
