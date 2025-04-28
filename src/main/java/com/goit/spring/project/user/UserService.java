package com.goit.spring.project.user;

// Імпортуємо необхідні класи для роботи з користувачами, шифруванням та сервісами
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

// Анотація, що визначає цей клас як сервісний компонент у Spring (буде автоматично створено через Dependency Injection)
@Service
public class UserService {

    // Сервіс (ready to use DAO) для збереження та пошуку користувачів у базі даних через JDBC
    private final JdbcUserDetailsManager jdbcUserDetailsManager;

    // Енкодер паролів для безпечного хешування перед збереженням
    private final PasswordEncoder passwordEncoder;

    // Конструктор класу, через який Spring автоматично передасть залежності
    public UserService(JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    // Метод для реєстрації нового користувача на основі даних із DTO
    public void registerUser(UserRegistrationDto dto) {
        // Створюємо об'єкт UserDetails — спеціальний об'єкт, який використовує Spring Security для автентифікації
        UserDetails user = User.withUsername(dto.getUsername()) // Встановлюємо ім'я користувача з DTO
                .password(passwordEncoder.encode(dto.getPassword())) // Шифруємо пароль перед збереженням
                .roles("USER") // Призначаємо роль "USER" (можна змінити на інші за потреби)
                .build(); // Завершуємо побудову об'єкта UserDetails

        // Зберігаємо нового користувача в базу даних через JdbcUserDetailsManager
        jdbcUserDetailsManager.createUser(user);
    }
}