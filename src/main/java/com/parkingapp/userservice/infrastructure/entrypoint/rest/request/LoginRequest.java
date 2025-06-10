package com.parkingapp.userservice.infrastructure.entrypoint.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotEmpty(message = "Email is required")
        @Email(message = "EmailShould be valid")
        @Size(min = 6, max = 128, message = "Email must be between 6 and 128 characters")
        String email,
        @NotEmpty(message = "Password is required")
        @Size(min = 6, max = 64, message = "Password must be between 6 and 64 characters")
        String password
) {
}
