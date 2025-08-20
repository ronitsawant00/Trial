package com.example.todos;

import jakarta.validation.constraints.NotBlank;

public record Todo(
    long id,
    @NotBlank String title,
    boolean completed
) {}
