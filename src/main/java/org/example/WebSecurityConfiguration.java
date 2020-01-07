package org.example;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.autoconfigure.security.servlet.StaticResourceRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password("{noop}password").authorities("ROLE_USER").build(),
                User.withUsername("admin").password("{noop}admin").authorities("ROLE_USER", "ROLE_ADMIN", "ROLE_ACTUATOR").build()
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.to("info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().ignoringAntMatchers("/ws/**")
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")
                .and().httpBasic();
    }
}
