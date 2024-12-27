package com.parkingapp.userservice.domain.auth;

import com.parkingapp.userservice.application.login.RefreshToken;
import com.parkingapp.userservice.application.login.Token;

public record AuthTokens(Token token, RefreshToken refreshToken) {}
