package com.goit.spring.project.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Позначаємо, що цей клас є REST-контролером
// Spring автоматично зробить його обробником HTTP-запитів і буде повертати JSON (а не HTML)
@RestController

// Всі маршрути цього контролера починаються з /users
@RequestMapping("/users")
public class UserController {

    // Оголошуємо залежність на сервіс UserService
    // Цей сервіс буде виконувати бізнес-логіку реєстрації користувачів
    private final UserService userService;

    // Конструктор з одним параметром (UserService)
    // Завдяки цьому Spring автоматично впровадить залежність через Dependency Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Метод для обробки HTTP POST запиту на шлях /users/register
    @PostMapping("/register")
    public void register(@RequestBody UserRegistrationDto dto) {
        // Коли клієнт відправляє POST-запит із JSON-тілом, цей JSON автоматично буде перетворено на об'єкт UserRegistrationDto
        // Далі ми передаємо цей об'єкт у сервіс для обробки реєстрації
        userService.registerUser(dto);
    }
}
