package com.parkingapp.userservice.application.login;

public record LoginResponse(Token token, RefreshToken refreshToken) {}
