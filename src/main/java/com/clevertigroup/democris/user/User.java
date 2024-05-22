package com.clevertigroup.democris.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "users")
public record User(
        @Id
        String id,
        String username,
        String email,
        String password,
        LocalDateTime lastLogin,
        LocalDate birthday) {
}
