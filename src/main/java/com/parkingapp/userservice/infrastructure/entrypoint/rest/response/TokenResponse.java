package com.parkingapp.userservice.infrastructure.entrypoint.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(
        @JsonProperty("acces_token")
        String accessToken,
        @JsonProperty("refresh_token")
        String refreshToken
) {
}
