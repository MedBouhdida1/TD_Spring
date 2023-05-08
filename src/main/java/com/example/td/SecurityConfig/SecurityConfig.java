package com.example.td.SecurityConfig;


import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.formLogin(
                form->form.loginPage("/login").permitAll()
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        );
//        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.authorizeHttpRequests().requestMatchers("/user/*").hasRole("user")
        .requestMatchers("/admin/**").hasRole("admin")
        .requestMatchers("/").hasRole("user")
        .requestMatchers("/").hasRole("admin");
        return httpSecurity.build();

    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("123")).roles("user").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("user").build(),
                User.withUsername("user3").password(passwordEncoder.encode("12345")).roles("user").build(),
                User.withUsername("admin").password(passwordEncoder.encode("12345")).roles("admin","user").build())
        ;
    }



}
