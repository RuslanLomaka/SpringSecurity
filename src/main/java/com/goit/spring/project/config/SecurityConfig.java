// Пакет, у якому знаходиться цей клас конфігурації
package com.goit.spring.project.config;

// Імпортуємо DataSource — об'єкт, який дає доступ до бази даних через JDBC
import javax.sql.DataSource;

// Імпортуємо анотації та класи Spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

// Позначаємо, що цей клас є конфігураційним — Spring буде створювати @Bean-и на основі нього
@Configuration

// Активуємо механізми Spring Security у цьому проєкті
@EnableWebSecurity
public class SecurityConfig {

    // Створюємо @Bean, який відповідає за зчитування користувачів з бази через JDBC
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        // Створюємо новий JdbcUserDetailsManager і передаємо йому DataSource (підключення до бази даних)
        // Він буде використовувати таблиці users та authorities для пошуку користувачів та ролей
        return new JdbcUserDetailsManager(dataSource);
    }

    // Створюємо @Bean для шифрування паролів
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Використовуємо BCryptPasswordEncoder — безпечний алгоритм шифрування паролів
        // За замовченням використовується work factor 10 (2^10 ітерацій хешування)
        return new BCryptPasswordEncoder(31);
    }
}
