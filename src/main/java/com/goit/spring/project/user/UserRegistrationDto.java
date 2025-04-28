package com.goit.spring.project.user;

import lombok.Getter;
import lombok.Setter;

// DTO (Data Transfer Object) потрібен для чистого переносу даних від клієнта в контролер
// Використовується щоб відділити вхідні дані від бізнес-логіки та базових ентіті
@Getter
@Setter
public class UserRegistrationDto {
    private String username;
    private String password;
}
