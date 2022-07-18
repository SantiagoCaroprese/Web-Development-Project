package com.javeriana.web.project.Shared.Infrastructure.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        //TODO: Activate admin-only patterns
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/employees/login").permitAll()
                .antMatchers(HttpMethod.POST, "/employees").permitAll()
                .antMatchers(HttpMethod.DELETE, "/employees/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/employees/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/properties").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.PUT, "/properties/{propertyId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE,"/properties/{propertyId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.GET,"/properties/{propertyId}").permitAll()
                .antMatchers(HttpMethod.GET,"/properties").permitAll()
                .antMatchers(HttpMethod.POST, "/properties/{propertyId}/offers").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.PUT, "/properties/{propertyId}/offers/{offerId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE, "/properties/{propertyId}/offers/{offerId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/appointments").permitAll()
                .antMatchers(HttpMethod.POST, "/appointments/unassigned").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/properties/{propertyId}/images").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE, "/properties/{propertyId}/images/{indexInList}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/appointments/expired").denyAll()
                .antMatchers(HttpMethod.PUT, "/appointments/{appointmentId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/questions").permitAll()
                .antMatchers(HttpMethod.PUT, "/questions/{questionId}").permitAll()
                .antMatchers(HttpMethod.GET, "/appointments/assigned").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.GET, "/appointments/unassigned").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE, "/appointments/{appointmentId}").permitAll()
                .antMatchers(HttpMethod.GET, "/questions/unanswered").hasRole("EMPLOYEE")
                .anyRequest().permitAll();
    }

}
