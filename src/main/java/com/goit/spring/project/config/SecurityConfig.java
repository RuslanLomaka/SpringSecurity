package com.goit.spring.project.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

// Marks this class as a configuration class — Spring will create @Beans based on it
@Configuration

// Enables Spring Security mechanisms in the project
@EnableWebSecurity
public class SecurityConfig {

    // Defines a @Bean for reading users from the database via JDBC
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        // Creates a new JdbcUserDetailsManager and passes it the DataSource (connection to database)
        // It will use the "users" and "authorities" tables to find users and their roles
        return new JdbcUserDetailsManager(dataSource);
    }

    // Defines a @Bean for password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Uses BCryptPasswordEncoder — a safe password hashing algorithm
        // Sets a work factor of 14 (2^14 hashing rounds) for increased security
        return new BCryptPasswordEncoder(14);
    }
}
